package com.cn.tacocloud2021.dao;

import com.cn.tacocloud2021.entity.Order;

public interface OrderRepository {
    Order save(Order order);
}
