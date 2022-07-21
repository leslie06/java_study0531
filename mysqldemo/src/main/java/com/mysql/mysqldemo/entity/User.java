package com.mysql.mysqldemo.entity;

import lombok.Data;

/**
 * @Description 登录的用户表
 * @Author leslie
 * @Date 2022/7/21 15:08
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
}
