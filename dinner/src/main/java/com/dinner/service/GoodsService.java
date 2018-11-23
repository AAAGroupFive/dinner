package com.dinner.service;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsService
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:49
 */
public interface GoodsService {
    /**
     * 获取商品列表
     * @param map
     * @return
     */
    List<Map> goodsList(Map map);
}
