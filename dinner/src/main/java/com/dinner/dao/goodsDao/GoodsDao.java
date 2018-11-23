package com.dinner.dao.goodsDao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsDao
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:45
 */
/*@CacheNamespace(implementation = RedisCache.class)*/
public interface GoodsDao {
    /**
     * 获取商品列表
     * @param map
     * @return
     */
    @Select(value = "select * from tab_goods")
    List<Map> goodsList(Map map);
}
