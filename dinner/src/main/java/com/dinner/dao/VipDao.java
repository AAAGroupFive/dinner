package com.dinner.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:VipDao
 * discription:
 * author:panjing
 * createTime:2018-11-23 08:52
 */
public interface VipDao {
    /**
     * 获取会员列表
     * @param map
     * @return
     */
    List<Map> VipQuery(Map map);
}
