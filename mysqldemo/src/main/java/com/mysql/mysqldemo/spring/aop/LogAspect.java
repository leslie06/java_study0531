package com.mysql.mysqldemo.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/14 22:49
 **/
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(public * com.mysql.mysqldemo.spring.*.*(..))")
    public void pointcut(){
    }
    @Before("pointcut()")
    public void beforeLog(){
        System.out.println("请求打印日志");
    }
    @After("pointcut()")
    public void afterLog(){
        System.out.println("请求响应日志");
    }
}
