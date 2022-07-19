package com.mysql.mysqldemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/20 0:17
 **/
@Data
@Entity(name = "person")
public class People {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String city;
}
