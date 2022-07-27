package com.mysql.mysqldemo.spring.inject;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/27 22:13
 **/
@Service("a")
public class AStudent implements Student {
    @Override
    public void introduce() {
        System.out.println("jack");
    }
}
