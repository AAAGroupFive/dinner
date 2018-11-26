package com.dinner.dao.VipDao;


import java.util.List;
import java.util.Map;

/**
 * className:VipDao
 * discription:
 * author:panjing
 * createTime:2018-11-23 08:52
 */
public interface VipDao {
    /**
     * 获取会员列表
     * @param map
     * @return
     */
    List<Map> VipQuery(Map map);

    /**
     * 分页数量
     * @return
     */
    int VipGetPageCount();

    /**
     * 新增会员
     * @param map
     * @return
     */
    int VipAdd (Map map);

    /**
     * 会员更新
     * @param map
     * @return
     */
    int VipUpdate(Map map);

    /**
     * 会员删除
     * @param map
     * @return
     */
    int VipDelete(Map map);
}
