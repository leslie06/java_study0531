package com.mysql.mysqldemo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ZParams;

import java.util.*;

/**
 * @Description对文章进行投票实例
 * 用hash存储文章信息 article:92617 title link poster time votes
 * 用set集合存储为100408号文章投票的用户，voted:100408 user:001 user:002
 * 两个zset有序集合:
 * 一个根据时间排序
 * 一个根据评分排序
 * @Author leslie
 * @Date 2022/7/24 21:57
 **/
public class ArticleVoteByRedis {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public static void main(String[] args) {
        new ArticleVoteByRedis().run();
    }

    public void run(){
        Jedis conn = new Jedis("127.0.0.1",6379);
        //发布新的文章
        String articleId = postArticle(conn,"username","A title","www.baidu.com");
        System.out.println("我们发布了一个id是" + articleId + "的新文章");
        System.out.println("它的hash结构如下：");
        Map<String,String> articleData = conn.hgetAll("article:" + articleId);
        for(Map.Entry<String,String> entry : articleData.entrySet()){
            System.out.println("    " + entry.getKey() + " : " + entry.getValue());
        }
        //开始投票
        articleVote(conn,"other_user","article:" + articleId);
        String votes = conn.hget("article:" + articleId,"votes");
        System.out.println("我们已投票，现在的投票数为：" + votes);
        System.out.println("目前获得投票数最高的文章是：");
        List<Map<String,String>> articles = getArticles(conn,1);
        printArticles(articles);

        addGroups(conn,articleId,new String[]{"new-group"});
        System.out.println("我们把文章添加到一个新组里，其他的文章包括：");
        articles = getGroupArticles(conn,"new-group",1);
        printArticles(articles);
    }

    /**
     * 发布一篇新文章
     */
    public String postArticle(Jedis conn,String user,String title,String link){
        //用incr指令生成文章id
        String articleId = String.valueOf(conn.incr("article:"));
        String voted = "voted:" + articleId;
        //用set存储为1号文章投票的所有用户：user1 user2
        conn.sadd(voted,user);
        //设置过期时间
        conn.expire(voted,ONE_WEEK_IN_SECONDS);
        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String, String> articleData = new HashMap<>();
        articleData.put("title",title);
        articleData.put("link",link);
        articleData.put("user",user);
        articleData.put("now",String.valueOf(now));
        articleData.put("votes","1");
        //将文章信息存储到hash
        conn.hmset(article,articleData);
        conn.zadd("score:",now + VOTE_SCORE,article);
        conn.zadd("time:",now,article);

        return articleId;
    }
    /**
     * 对文章进行投票
     */
    public void articleVote(Jedis conn,String user,String article){
        //计算文章的投票截至时间
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if(conn.zscore("time:",article) < cutoff){
            return;
        }
        //从article:id中取出文章id
        String articleId = article.substring(article.indexOf(':') + 1);
        //如果用户是第一次投票，增加投票数和分值
        if(conn.sadd("voted:" + articleId,user) == 1){
            conn.zincrby("score:",VOTE_SCORE,article);
            conn.hincrBy(article,"votes",1);
        }
    }
    public List<Map<String,String>> getArticles(Jedis conn,int page){
        return getArticles(conn,page,"score:");
    }

    /**
     * 取出评分最高的文章
     */
    public List<Map<String,String>> getArticles(Jedis conn,int page,String order){
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;
        //根据分值，降序取出articleId
        List<String> ids = conn.zrevrange(order, start, end);

        List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
        for(String id : ids){
            //根据文章id获取文章的详细信息
            Map<String, String> articleData = conn.hgetAll(id);
            articleData.put("id",id);
            articles.add(articleData);
        }
        return articles;
    }
    /**
     * 把文章添加到群组
     */
    public void addGroups(Jedis conn,String articleId,String[] toAdd){
        String article = "article:" + articleId;
        for(String group : toAdd){
            conn.sadd("group:" + group,article);
        }
    }
    public List<Map<String,String>> getGroupArticles(Jedis conn, String group, int page) {
        return getGroupArticles(conn, group, page, "score:");
    }
    /**
     * 获取分组的文章
     */
    public List<Map<String,String>> getGroupArticles(Jedis conn,String group,int page,String order){
        //为每个群组都创建一个键
        String key = order + group;
        if(!conn.exists(key)){
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            //求交集
            conn.zinterstore(key,params,"group:" + group,order);
            conn.expire(key,60);
        }
        return getArticles(conn,page,key);
    }

    /**
     * 遍历文章的对象集合
     */
    private void printArticles(List<Map<String,String>>articles){
        for(Map<String,String>article : articles){
            System.out.println(" id: " + article.get("id"));
            for(Map.Entry<String,String>entry : article.entrySet()){
                if(entry.getKey().equals("id")){
                    continue;
                }
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
