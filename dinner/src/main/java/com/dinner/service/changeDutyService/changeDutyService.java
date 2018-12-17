package com.dinner.service.changeDutyService;

import java.util.List;
import java.util.Map;

/**
 * className:changeDutyService
 * discription:
 * author:panjing
 * createTime:2018-12-08 13:55
 */
public interface changeDutyService {
    /**
     * 查询交班所需要的信息
     * @return
     */
   Map queryChangeDuty();
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
