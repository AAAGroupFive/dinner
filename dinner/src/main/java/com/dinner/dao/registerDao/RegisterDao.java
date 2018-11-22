package com.dinner.dao.registerDao;

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
     * @param
     * @return
     */
    @Insert("insert  into tab_vip values (1,'wxz2','13253536393',666888,1,555,1)")
    int registerUserLoginMessage();
}
