package com.dinner.dao.login;

import com.dinner.Entity1.User;

import java.util.Map;

/**
 * className:UserDao
 * discription:
 * author:panjing
 * createTime:2018-12-13 15:31
 */
public interface UserDao {

    User findByParam (Map map);

}
