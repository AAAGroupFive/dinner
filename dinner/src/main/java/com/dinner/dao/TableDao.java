package com.dinner.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * className:TableDao
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 14:59
 */
@CacheNamespace(implementation = RedisCache.class)
public interface TableDao {

    /**
     * 查询桌子
     * @param
     * @return
     */
    @Select("select * from tab_table")
    List<Map> getList();
}
