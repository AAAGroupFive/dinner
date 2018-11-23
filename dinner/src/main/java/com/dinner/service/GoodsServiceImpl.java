package com.dinner.service;

import com.dinner.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsServiceImpl
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:51
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Map> goodsList(Map map) {
        return goodsDao.goodsList(map);
    }
}
