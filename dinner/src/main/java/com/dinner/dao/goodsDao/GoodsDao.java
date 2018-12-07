package com.dinner.dao.goodsDao;


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
     * 获取商品列表 分页
     * @param map
     * @return
     */
    //@Select(value = "select * from tab_goods")
    List<Map> goodsList(Map map);
    int countFoodsList();

    /**
     * 插入到盘点表
     * @param map
     * @return
     */
    int addInventory(Map map);

   /**
     * 商品剩余数量更新
     * @param map
     * @return
     */
    int updateGoods(Map map);

    /**
     * 获取盘点人和盘点时间
     * @param map
     * @return
     */
    List<Map> inventoryList(Map map);

    /**
     * 获取盘点人的详细记录
     * @param map
     * @return
     */
    List<Map> inventoryDetails(Map map);

    /**
     * 插入进货表
     * @param map
     * @return
     */
    int addPutGoods(Map map);

    /**
     * 获取进货列表 分页
     * @param map
     * @return
     */
    List<Map> putGoodsList(Map map);
    int countPutList();

    /**
     * 成功进货 改变食材数量
     * @param map
     * @return
     */
    int addPutRecord(Map map);
    int updateGoods2(Map map);
    /**
     * 驳回进货
     * @param map
     * @return
     */
    int addPutRecord2(Map map);

    /**
     * 删除进货列表
     * @param map
     * @return
     */
    int deletePut(Map map);

    /**
     * 获取所有进货记录 分页
     * @param map
     * @return
     */
    List<Map> putRecord(Map map);
    int countPutRecordList();

}
