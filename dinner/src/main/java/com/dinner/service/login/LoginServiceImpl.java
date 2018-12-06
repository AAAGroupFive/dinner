package com.dinner.service.login;

import com.dinner.dao.login.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LoginServiceImpl
 * discriptoin:
 * author:王朝军
 * createTime:2018-12-05 14:52
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public List<Map> userLogin(Map map) {
        return loginDao.userLogin(map);
    }
}
