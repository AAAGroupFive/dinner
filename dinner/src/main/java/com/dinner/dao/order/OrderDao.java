package com.dinner.dao.order;

import java.util.List;
import java.util.Map;

/**
 * className:OrderDao
 * describe:
 * author:邢芳彬
 * createTime:2018-11-24 16:13
 */
public interface OrderDao {

    /**
     * 获取菜单列表
     * @return
     */
    List<Map> goodList();

    /**
     * 插入订单
     * @param map
     * @return
     */
    int order(Map map,Map map1);

}