package com.mysql.mysqldemo.controller;

import com.mysql.mysqldemo.entity.Person;
import com.mysql.mysqldemo.mysql.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/19 21:13
 **/
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @RequestMapping("/person")
    public Person getPersonById(){
        return personRepository.findOne(1);
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello,world!";
    }

    
}
