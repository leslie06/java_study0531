package com.mysql.mysqldemo.entity;

import lombok.Data;
import java.util.Date;

/**
 * @Description 积分
 * @Author leslie
 * @Date 2022/10/25 18:38
 **/
@Data
public class Integral {
    private String integralId;
    private String commodityId;
    private Integer integral;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
    private Integer isDeleted;
}
