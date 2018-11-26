package com.dinner.service.orderService;

import com.dinner.dao.order.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:OrderServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-11-24 16:15
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int update(int tabNo) {
        return orderDao.update(tabNo);
    }

    @Override
    public int order(Map map) {
        System.out.println(map);
        return orderDao.order(map);
    }

    @Override
    public List<Map> goodList() {
        return orderDao.goodList();
    }
}
