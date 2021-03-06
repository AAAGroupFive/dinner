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
    int order(Map map);

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

    /**
     * 查询已经点的菜
     * @param map
     * @return
     */
    List<Map> alreadyList(Map map);

    /**
     * 上桌
     * @param map
     * @return
     */
    int foodUp(Map map);

    /**
     * 关闭桌子
     * @param map
     * @return
     */
    int close(Map map);

    int closeTable(Map map);

    /**
     * 收钱记入账单
     * @param map
     * @return
     */
    int put(Map map);

    /**
     * vip扣费
     * @param map
     * @return
     */
    int vip(Map map);

    int checkMoney(Map map);
}
