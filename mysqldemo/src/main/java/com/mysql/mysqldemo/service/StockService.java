package com.mysql.mysqldemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mysql.mysqldemo.entity.Commodity;
import com.mysql.mysqldemo.entity.Stock;

public interface StockService extends IService<Stock> {
    void reduceStock(Commodity commodity);
}
