package com.mysql.mysqldemo.controller;

import com.mysql.mysqldemo.entity.User;
import com.mysql.mysqldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/21 15:36
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @RequestMapping("/register")
    public boolean isRegister(User user){
        if(userService.register(user)){
            return true;
        }else{
            return false;
        }
    }
    //登录
    @RequestMapping("/login")
    public boolean isLogin(User user){
        if(userService.login(user)){
            return true;
        }else{
            return false;
        }
    }
}
