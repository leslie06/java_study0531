package com.cn.tacocloud2021.entity;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private long id;
    @NotNull
    @Size(min=5,message = "Name must be at least 5 characters long")
    private String name;
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
    //创建日期
    private Date createdAt;

}
