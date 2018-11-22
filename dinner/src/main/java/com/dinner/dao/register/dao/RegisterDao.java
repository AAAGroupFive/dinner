package com.dinner.dao.register.dao;

import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * className:RegisterDao
 * discriptoin:
 * author:wxz
 * createTime:2018-11-22 16:35
 */
public interface RegisterDao {
    /**
     *
     * @param map
     * @return
     */
    @Insert(value = "insert  into tab_vip values (1,'wxz','13253536393',666888,1,555,1)")
    List<Map> registerUserLoginMessage(Map map);
}
