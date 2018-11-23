package com.dinner.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:test1
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-09:35
 */
public interface test1 {

    @Select("select * from tab_table")
    List<Map> getList();
}
