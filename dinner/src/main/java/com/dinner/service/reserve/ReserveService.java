package com.dinner.service.reserve;

import java.util.List;
import java.util.Map;

/**
 * className:ReserveService
 * describe:
 * author:邢芳彬
 * createTime:2018-12-17 14:05
 */
public interface ReserveService {


    /**
     * 查询预订列表
     * @return
     */
    List<Map> reList();

    /**
     * 预订列表
     * @return
     */
    List<Map> reserveList(String selectDate,Integer time);

    /**
     * 添加预定信息
     *
     * @return
     */
    int addReserve(Map map);

}
