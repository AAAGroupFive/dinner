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
     * @param list
     * @return
     */
    int order(Map map/*,List list*/);


    /**
     * 改变桌子状态
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 插入用户点的菜
     * @param map
     * @return
     */
    int insertChoose(List<Map> map);

    /**
     * 结账
     * @param map
     * @return
     */
    List<Map> countHistory(Map map);

    /**
     * 结账详情
     * @param map
     * @return
     */
    List<Map> countDetails(Map map);
}
