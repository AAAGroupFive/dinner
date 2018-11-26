package com.dinner.service.tabService;

import com.dinner.dao.tableDao.TableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:TableServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-11-23 16:23
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;

    @Override
    public List<Map> getList() {
        return tableDao.getList();
    }
}
