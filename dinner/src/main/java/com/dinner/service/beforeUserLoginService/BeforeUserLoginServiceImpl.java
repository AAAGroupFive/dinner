package com.dinner.service.beforeUserLoginService;

import com.dinner.dao.beforeUserLoginDao.BeforeUserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:BeforeUserLoginServiceImpl
 * discriptoin:
 * author:J-Hsitsung.s
 * createTime:2018-12-05 13:51
 */
@Service
public class BeforeUserLoginServiceImpl implements  BeforeUserLoginService {
    //spring 实例化dao
    @Autowired
    private BeforeUserLoginDao beforeUserLoginDao;

    /***
     * 重写 登录检查验证方法
     * @param map
     * @return
     */
    @Override
    public int checkUser(Map map) {
        return beforeUserLoginDao.checkUser(map);
    }
}
