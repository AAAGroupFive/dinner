package com.dinner.dao.beforeUserLoginDao;

import java.util.List;
import java.util.Map;

/**
 * className:BeforeUserLoginDao
 * discriptoin: 普通用户 后台 数据库 用户名 密码 登录验证
 * author:J-Hsitsung.s
 * createTime:2018-12-04 15:12
 */
public interface BeforeUserLoginDao {
    /**
     * 用户登录检查@return
     */
    List<Map> checkUser(Map map);
}
