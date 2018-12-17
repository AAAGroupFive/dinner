package com.dinner.dao.reserve;

import java.util.Map;

/**
 * className:ReserveDao
 * describe:
 * author:邢芳彬
 * createTime:2018-12-17 10:04
 */
public interface ReserveDao {

    /**
     * 添加预定信息
     * @return
     */
    int addReserve(Map map);

    /**
     * 改变桌子状态
     * @param map
     * @return
     */
    int updateState(Map map);
}
