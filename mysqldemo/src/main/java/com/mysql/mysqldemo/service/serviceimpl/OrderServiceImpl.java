package com.mysql.mysqldemo.service.serviceimpl;

import com.mysql.mysqldemo.dao.OrderDao;
import com.mysql.mysqldemo.entity.Commodity;
import com.mysql.mysqldemo.entity.Orders;
import com.mysql.mysqldemo.service.OrderService;
import com.mysql.mysqldemo.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description
 * @Author leslie
 * @Date 2022/10/26 11:30
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void placeAnOrder(Commodity commodity) {
        Orders order = new Orders();
        String orderId = UUIDUtil.getUUid();
        order.setOrderId(orderId);
        order.setCommodityId(commodity.getCommodityId());
        order.setOrderDetail("恭喜下单");
        order.setCreator("leslie");
//        order.setCreateTime(new Date());
        orderDao.insert(order);
    }
}
