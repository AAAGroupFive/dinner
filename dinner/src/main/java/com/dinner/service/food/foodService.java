package com.dinner.service.food;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:foodService
 * describe:
 * author:邢芳彬
 * createTime:2018-12-12 15:35
 */
public interface foodService {

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
