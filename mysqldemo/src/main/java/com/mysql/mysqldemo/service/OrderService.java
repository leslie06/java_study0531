package com.mysql.mysqldemo.service;

import com.mysql.mysqldemo.entity.Commodity;

public interface OrderService {
    void placeAnOrder(Commodity commodity);
}
