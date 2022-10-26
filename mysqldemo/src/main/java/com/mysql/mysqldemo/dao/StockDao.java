package com.mysql.mysqldemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mysql.mysqldemo.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StockDao extends BaseMapper<Stock> {
}
