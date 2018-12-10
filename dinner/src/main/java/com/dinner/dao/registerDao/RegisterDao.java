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

    int registerUserLoginMessage(Map map);
}
