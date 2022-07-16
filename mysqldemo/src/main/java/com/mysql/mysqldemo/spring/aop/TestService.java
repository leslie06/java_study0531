package com.mysql.mysqldemo.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/14 22:57
 **/
@Service
public class TestService {

    public void doSomething1() {
        System.out.println("==doSomething1==");
    }

    public void doSomething2() {
        System.out.println("==doSomething2==");
    }

    public void doSomething3() {
        System.out.println("==doSomething3==");
    }
}
