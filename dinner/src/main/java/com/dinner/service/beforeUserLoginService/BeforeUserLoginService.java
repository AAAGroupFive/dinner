package com.dinner.service.beforeUserLoginService;

import java.util.List;
import java.util.Map;

/**
 * className:BeforeUserLoginService
 * discriptoin: 用户登录service接口
 * author:J-Hsitsung.s
 * createTime:2018-12-05 13:50
 */
public interface BeforeUserLoginService {
    /***
     * 用户登录方法
     * @param map
     * @return
     */
    List<Map> checkUser(Map map);
}
