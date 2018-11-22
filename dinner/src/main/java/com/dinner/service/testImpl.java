package com.dinner.service;

import com.dinner.dao.test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:testImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 15:11
 */
@Service
public class testImpl implements test {

    @Autowired
    private test1 test1;

    @Override
    public List<Map> getList(Map map) {
        return test1.getList(map);
    }
}
