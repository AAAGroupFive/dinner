package com.dinner.service.consume;

import com.dinner.dao.consume.ConsumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:ConsumeServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-12-19 11:20
 */
@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private ConsumeDao consumeDao;

    @Override
    public List<Map> consumeList() {
        return consumeDao.consumeList();
    }
}
