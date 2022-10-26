package com.mysql.mysqldemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description 订单
 * @Author leslie
 * @Date 2022/10/25 18:37
 **/
@Data
public class Orders {
    private String orderId;
    private String commodityId;
    private String orderDetail;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
    private Integer isDeleted;
}
