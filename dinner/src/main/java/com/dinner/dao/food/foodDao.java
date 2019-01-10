package com.dinner.dao.food;

import java.util.Map;

/**
 * className:foodDao
 * describe:
 * author:邢芳彬
 * createTime:2018-12-12 15:34
 */
public interface foodDao {

    /**
     * 添加菜
     * @param map
     * @return
     */
    int addFood(Map map);

    /**
     * 删除菜
     * @param map
     * @return
     */
    int delFood(Map map);

    /**
     * 更新菜
     * @param map
     * @return
     */
    int updateFood(Map map);

    /**
     * 统计菜品
     * @return
     */
    int countFood();
}
