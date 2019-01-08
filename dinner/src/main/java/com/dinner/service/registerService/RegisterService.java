package com.dinner.service.registerService;

import java.util.List;
import java.util.Map;

/**
 * className:RegisterService
 * discriptoin:用户注册 service层
 * author:wxz
 * createTime:2018-11-22 16:32
 */
public interface RegisterService {

    /**
     * @return
     */
    int registerUserLoginMessage(Map map);

     List<Map> checkUser(Map map);
}
