package com.mysql.mysqldemo.controller;

/**
 * @Description
 * @Author leslie
 * @Date 2022/10/25 17:40
 **/

import com.mysql.mysqldemo.entity.Commodity;
import com.mysql.mysqldemo.entity.Stock;
import com.mysql.mysqldemo.service.OrderService;
import com.mysql.mysqldemo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commodity")
public class TransactionController {
    @Autowired
    private StockService stockService;
    @Autowired
    private OrderService orderService;
    @PostMapping("/buyGoods")
    public void buyGoods(){
        Commodity commodity = new Commodity();
        commodity.setCommodityId("001");
        stockService.reduceStock(commodity);
        orderService.placeAnOrder(commodity);
    }
}
