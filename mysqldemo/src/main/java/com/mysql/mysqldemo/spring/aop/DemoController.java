package com.mysql.mysqldemo.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/14 23:08
 **/
@RestController
@RequestMapping("/home")
public class DemoController {
    @Autowired
    private TestService testService;
    @GetMapping("/log")
    public void getLog(){
        System.out.println("==doSomething1==");
    }

}
