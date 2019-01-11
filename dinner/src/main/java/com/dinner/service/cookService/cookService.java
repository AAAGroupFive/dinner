package com.dinner.service.cookService;

import java.util.List;
import java.util.Map;

/**
 * className:cookService
 * discriptoin:
 * author:王朝军
 * createTime:2019-01-11 21:17
 */
public interface cookService {
    /**
     * 待做
     * @param map
     * @return
     */
    List<Map> cookList(Map map);

    /**
     * 已做
     * @param map
     * @return
     */
    List<Map> cookedList(Map map);
    /**
     * 菜品状态
     * @param map
     * @return
     */
    int updateCook(Map map);
}
