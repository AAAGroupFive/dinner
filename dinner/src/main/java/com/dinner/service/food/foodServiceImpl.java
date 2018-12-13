package com.dinner.service.food;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import com.dinner.dao.food.foodDao;
import org.springframework.stereotype.Service;

/**
 * className:foodServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-12-12 15:36
 */
@Service
public class foodServiceImpl implements foodService {

    @Autowired
    private foodDao foodDao;

    @Override
    public int addFood(Map map) {
        return foodDao.addFood(map);
    }

    @Override
    public int delFood(Map map) {
        return foodDao.delFood(map);
    }

    @Override
    public int updateFood(Map map) {
        return foodDao.updateFood(map);
    }
}
