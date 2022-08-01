package com.mysql.mysqldemo.redis;

import redis.clients.jedis.Jedis;

/**
 * @Description 互斥锁解决缓存击穿
 * @Author leslie
 * @Date 2022/8/1 11:44
 **/
public class CachePenetration {
    public static void main(String[] args) {
        Jedis conn = new Jedis("127.0.0.1",6379);
        System.out.println(getProductById(conn,"001"));
    }

    public static String getProductById(Jedis conn, String id){
        String desc = conn.get("id");
        if(desc == null){
            if(conn.setnx("lock_id","1") == 1){
                conn.expire("lock_id",30);
                try{
                    desc = getFromDB(id);
                }finally {
                    conn.del("lock_id");
                    return desc;
                }
            }
        }
        return desc;
    }

    public static String getFromDB(String id){
        return "iphone 13";
    }
}
