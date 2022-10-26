package com.mysql.mysqldemo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description 商品
 * @Author leslie
 * @Date 2022/10/25 18:30
 **/
@Data
public class Commodity {
    private String commodityId;
    private String commodityName;
    private String color;
    private BigDecimal price;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
    private Integer isDeleted;
}
