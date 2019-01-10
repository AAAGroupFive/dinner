package com.dinner.service.VipService;

import java.util.List;
import java.util.Map;

/**
 * className:VipService
 * discription:
 * author:panjing
 * createTime:2018-11-23 15:14
 */
public interface VipService {
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
    /**
     * 统计会员
     * @return
     */
    int countVip();
}
