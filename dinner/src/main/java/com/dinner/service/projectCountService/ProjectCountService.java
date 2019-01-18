package com.dinner.service.projectCountService;

import java.util.List;
import java.util.Map;

/**
 * className:ProjectCountService
 * discription:
 * author:panjing
 * createTime:2018-11-29 18:40
 */

public interface ProjectCountService {

    /**
     * 每月财务统计
     * @return
     */
    List<Map> getMoneyCount();
    /**
     * vip充值统计
     *
     * @return
     */
    List<Map> getVipMoneyCount();
}
