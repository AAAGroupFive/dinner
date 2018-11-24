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
}
