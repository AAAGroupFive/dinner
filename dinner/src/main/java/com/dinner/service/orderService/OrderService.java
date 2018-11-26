package com.dinner.service.orderService;


import java.util.List;
import java.util.Map;

/**
 * className:orderService
 * describe:
 * author:邢芳彬
 * createTime:2018-11-24 16:15
 */
public interface OrderService {

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
    int order(Map map);

    /**
     * 改变桌子状态
     * @param tabNo
     * @return
     */
    int update(int tabNo);
}
