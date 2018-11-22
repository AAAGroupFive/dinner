package com.dinner.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * className:test1
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 14:59
 */
@CacheNamespace(implementation = RedisCache.class)
public interface test1 {
    /**
     * 员工列表方法
     * @param map
     * @return
     */
    @Select("select * from tab_type")
    List<Map> getList(Map map);
}
