package com.mysql.mysqldemo.entity;

import lombok.Data;

/**
 * @Description
 * @Author leslie
 * @Date 2022/7/19 18:10
 **/
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String city;

    public Person(int id, String name, int age, String gender, String city) {
    }

    public Person() {

    }
}
