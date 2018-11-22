package com.dinner.service.registerService;

import com.dinner.dao.register.dao.RegisterDao;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.Insert;

import java.security.PrivateKey;
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
    List<Map> registerUserLoginMessage(Map map);
}
