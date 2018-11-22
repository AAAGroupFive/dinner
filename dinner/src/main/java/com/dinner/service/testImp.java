package com.dinner.service;

import com.dinner.dao.test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:testImp
 * discription:
 * author:panjing
 * createTime:2018-11-22 15:04
 */
@Service
public class testImp implements test{

    @Autowired
    private test1 a;

    @Override
    public List<Map> getList(Map map) {
        return a.getList(map);
    }
}
