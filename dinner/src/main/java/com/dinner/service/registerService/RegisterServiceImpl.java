package com.dinner.service.registerService;

import com.dinner.dao.register.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:RegisterServiceImpl
 * discriptoin:
 * author:wxz
 * createTime:2018-11-22 16:37
 */
@Service
public class RegisterServiceImpl implements  RegisterService{
    @Autowired
    private RegisterDao registerDao;
    @Override
    public List<Map> registerUserLoginMessage(Map map) {
        return registerDao.registerUserLoginMessage(map);
    }
}
