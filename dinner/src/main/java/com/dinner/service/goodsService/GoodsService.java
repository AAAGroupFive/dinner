package com.dinner.service.goodsService;

import java.util.List;
import java.util.Map;

/**
 * className:GoodsService
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:49
 */
public interface GoodsService {
    /**
     * 获取商品列表
     * @param map
     * @return
     */
    List<Map> goodsList(Map map);
    /**
     * 商品分页数据
     * @param
     * @return
     */
    int countFoodsList();
    /**
     * 插入到盘点表 商品剩余数量更新
     * @param map
     * @return
     */
    int updateInventory(Map map);
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
     * 获取进货列表
     * @param map
     * @return
     */
    List<Map> putGoodsList(Map map);
    int countPutList();
    /**
     * 成功进货
     * @param map
     * @return
     */
    int addPutRecord(Map map);
    /**
     * 驳回进货
     * @param map
     * @return
     */
    int addPutRecord2(Map map);
    /**
     * 获取所有进货记录
     * @param map
     * @return
     */
    List<Map> putRecord(Map map);
    int countPutRecordList();

}
