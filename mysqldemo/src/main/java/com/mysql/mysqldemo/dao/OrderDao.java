package com.mysql.mysqldemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysql.mysqldemo.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao extends BaseMapper<Orders> {
}
