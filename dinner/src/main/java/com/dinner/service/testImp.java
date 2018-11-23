package com.dinner.service;

import com.dinner.dao.TableDao;
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
    private TableDao test1;

    @Override
    public List<Map> getList(Map map) {
        return null;
    }
}
