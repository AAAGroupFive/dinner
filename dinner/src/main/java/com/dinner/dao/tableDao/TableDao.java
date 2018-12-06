package com.dinner.dao.tableDao;


import java.util.List;
import java.util.Map;

/**
 * className:TableDao
 * describe:
 * author:邢芳彬
 * createTime:2018-11-23 16:25
 */
public interface TableDao {
    /**
     * 查询桌子
     * @param
     * @return
     */
    List<Map> getList();
}
