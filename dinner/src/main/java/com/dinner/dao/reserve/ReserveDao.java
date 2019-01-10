package com.dinner.dao.reserve;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * className:ReserveDao
 * describe:
 * author:邢芳彬
 * createTime:2018-12-17 10:04
 */
public interface ReserveDao {

    /**
     * 查询预订列表
     * @return
     */
    List<Map> reList();

    /**
     * 根据日期查询预订列表
     * @return
     */
    List<Map> reserveList(@Param("selectDate") String selectDate);

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
