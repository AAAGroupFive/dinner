package com.dinner.dao.changeDutyDao;

import java.util.List;
import java.util.Map;

/**
 * className:changeDutyDao
 * discription:
 * author:panjing
 * createTime:2018-12-08 14:35
 */
public interface changeDutyDao {
    /**
     * 查询交班所需要的信息
     *
     */
    /**
     * 查询上班留存
     * @return
     */
    Map queryChangeDuty();

    /**
     *
     * 查询本班金额（在消费表里）
     * @return
     */
    String queryMoney();

    /**
     * 查询接班员工（在员工表里）
     * @return
     */
   List<Map> queryJemp();

    /**
     * 添加交班记录
     * @return
     */
   int insert(Map map);

    /**
     * 查询交班记录
     * @return
     */
    List<Map> queryRecord();
}
