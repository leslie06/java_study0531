package com.cn.tacocloud2021.dao;

import com.cn.tacocloud2021.entity.Order;
import com.cn.tacocloud2021.entity.Taco;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author leslie
 * @Date 2022/6/30 20:15
 **/
@Repository
public class JdbcOrderRepository implements OrderRepository {
    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;
    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.orderInserter = new SimpleJdbcInsert(jdbc).withTableName("Taco_Order").usingGeneratedKeyColumns("id");
        this.orderTacoInserter = new SimpleJdbcInsert(jdbc).withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();
    }
    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        Long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco>tacos = order.getTacos();
        for(Taco taco : tacos){
            saveTacoToOrder(taco,orderId);
        }
        return order;
    }
    private long saveOrderDetails(Order order){
        @SuppressWarnings("unchecked")//屏蔽一些无关紧要的警告。
        Map<String,Object> values = objectMapper.convertValue(order,Map.class);
        values.put("placeAt",order.getPlacedAt());
        long orderId = orderInserter.executeAndReturnKey(values).longValue();
        return orderId;
    }
    private void saveTacoToOrder(Taco taco,long orderId){
        Map<String,Object> values = new HashMap<>();
        values.put("tacoOrder",orderId);
        values.put("taco",taco.getId());
        orderTacoInserter.execute(values);
    }
}
