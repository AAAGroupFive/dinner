package com.dinner.dao.RechargeDao;

import java.util.List;
import java.util.Map;

/**
 * className:RechargeDao
 * discription:
 * author:panjing
 * createTime:2018-12-03 14:04
 */

public interface RechargeDao {

    /**
     * 充值记录查询
     * @return
     * @param map
     */
    List<Map> RechargeQuery(Map map);
    /**
     * 分页数量
     * @return
     */
    int RechargeGetPageCount();

    /**
     * 充值
     * @return
     */
    int RechargeAdd(Map map);
}
