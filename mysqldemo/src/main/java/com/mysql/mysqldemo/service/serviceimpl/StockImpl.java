package com.mysql.mysqldemo.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.mysqldemo.dao.StockDao;
import com.mysql.mysqldemo.entity.Commodity;
import com.mysql.mysqldemo.entity.Stock;
import com.mysql.mysqldemo.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Description
 * @Author leslie
 * @Date 2022/10/25 19:08
 **/
@Service
@Slf4j
public class StockImpl extends ServiceImpl<StockDao,Stock> implements StockService {
    @Autowired
    private StockDao stockDao;
    @Override
    @Transactional
    public void reduceStock(Commodity commodity) {
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("COMMODITY_ID",commodity.getCommodityId());
        Stock stockInfo = stockDao.selectOne(queryWrapper);
        Stock stock = new Stock();
        UpdateWrapper<Stock> stockUpdateWrapper = new UpdateWrapper<>();
        stockUpdateWrapper.eq("COMMODITY_ID",commodity.getCommodityId());
        stock.setQuantity(stockInfo.getQuantity() - 1);
        stockDao.update(stock,stockUpdateWrapper);
    }
}
