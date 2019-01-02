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
     *注册
     * @param
     * @return
     */
    int registerUserLoginMessage(Map map);

	/***
	 * 检查用户是否存在
	 * @param map
	 * @return
	 */
	List<Map> checkUser(Map map);
}
