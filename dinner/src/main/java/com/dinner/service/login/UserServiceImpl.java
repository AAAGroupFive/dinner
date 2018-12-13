package com.dinner.service.login;

import com.dinner.Entity1.User;
import com.dinner.dao.login.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserServiceImpl
 * discription:
 * author:sjq
 * createTime:2018-12-10 09:33
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserId(String userid,String password) {
        Map map=new HashMap();
        map.put("userid",Integer.valueOf(userid));
        map.put("password",password);
        User byUsername = userDao.findByParam(map);
        return byUsername;
    }


}
