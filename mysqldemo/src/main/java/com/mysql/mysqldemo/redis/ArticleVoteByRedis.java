package com.mysql.mysqldemo.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

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

    /**
     * 发布并获取文章
     */
    public String postArticle(Jedis conn,String user,String title,String link){
        //用incr指令生成文章id
        String articleId = String.valueOf(conn.incr("article:"));

        String voted = "voted:" + articleId;
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
        conn.zadd("score",now + VOTE_SCORE,article);
        conn.zadd("time",now,article);

        return articleId;
    }
    /**
     * 对文章进行投票
     * @param conn
     * @param user
     * @param article
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



}
