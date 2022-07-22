package com.mysql.mysqldemo;

import com.mysql.mysqldemo.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/22 13:40
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 插入缓存数据
     */
    @Test
    public void set(){
        redisUtils.set("redis_key","redis_value");
    }
    /**
     * 读取缓存数据
     */
    @Test
    public void get(){
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }
}
