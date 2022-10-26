package com.mysql.mysqldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

/**
 * @Description 库存
 * @Author leslie
 * @Date 2022/10/25 18:35
 **/
@Data
public class Stock {
    private String stockId;
    private String commodityId;
    private Integer quantity;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifyTime;
    private Integer isDeleted;
}
