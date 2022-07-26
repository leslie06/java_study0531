package com.mysql.mysqldemo.redis;

import javafx.util.Callback;
import redis.clients.jedis.Jedis;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description
 * @Author leslie
 * @Date 2022/7/26 17:10
 **/
public class LoginAndShoppingCartRedis {
    /**
     * 根据token查找用户
     */
    public String checkToken(Jedis conn, String token){
        return conn.hget("login:",token);
    }
    /**
     *更新令牌
     */
    public void updateToken(Jedis conn,String token,String user,String item){
        long timestamp = System.currentTimeMillis() / 1000;
        //维持令牌和已登录用户之间的映射
        conn.hset("login:",token,user);
        //记录令牌最后一次出现的时间
        conn.zadd("recent:",timestamp,token);
        if(item != null){
            //记录用户浏览过的商品
            conn.zadd("viewed:" + token,timestamp,item);
            //移除旧的记录，只保留用户最近浏览的25个商品
            conn.zremrangeByRank("viewed:" + token,0,-26);
            conn.zincrby("viewed:",-1,item);
        }
    }
    /**
     *把商品添加到购物车
     * 每个购物车都是一个hash，存储的是商品id和商品数量的映射
     */
    public void addToCart(Jedis conn,String session,String item,int count){
        //如果数量不大于0，将移除该条目
        if(count <= 0){
            conn.hdel("cart:" + session,item);
        }else{
            conn.hset("cart:" + session,item,String.valueOf(count));
        }
    }
    /**
     * 定期缓存数据行
     */
    public void scheduleRowCache(Jedis conn,String rowId,int delay){
        conn.zadd("delay:",delay,rowId);
        conn.zadd("schedule:",System.currentTimeMillis() / 1000,rowId);
    }
    //网页缓存
    public String cacheRequest(Jedis conn, String request, Callback callback){
        if(!canCache(conn, request)){
            return callback != null ? (String) callback.call(request) : null;
        }
        String pageKey = "cache:" + hashRequest(request);
        //查找被缓存的页面
        String content = conn.get(pageKey);
        //如果页面还没被缓存，那么生成页面
        if(content == null && callback != null){
            content = (String) callback.call(request);
            //将新生成的页面放到缓存里面
            conn.setex(pageKey,300,content);
        }
        return content;
    }
    public boolean canCache(Jedis conn,String request){
        try {
            URL url = new URL(request);
            HashMap<String, String> params = new HashMap<String, String>();
            if(url.getQuery() != null){
                for(String param : url.getQuery().split("&")){
                    String[] pair = param.split("=",2);
                    params.put(pair[0],pair.length == 2 ? pair[1] : null);
                }
            }
            String itemId = extractItemId(params);
            if(itemId == null || isDynamic(params)){
                return false;
            }
            Long rank = conn.zrank("viewed:",itemId);
            return rank != null && rank < 10000;
        } catch (MalformedURLException e) {
            return false;
        }
    }
    public boolean isDynamic(Map<String,String> params){
        return params.containsKey("_");
    }
    public String extractItemId(Map<String,String> params){
        return params.get("item");
    }
    public String hashRequest(String request) {
        return String.valueOf(request.hashCode());
    }


}
