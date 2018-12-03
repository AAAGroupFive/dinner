package com.dinner.service.RechargeService;



import java.util.List;
import java.util.Map;

/**
 * className:RechargeSerive
 * discription:
 * author:panjing
 * createTime:2018-12-03 14:02
 *
 */

public interface RechargeSerive {
    /**
     * 充值记录查询
     * @return
     */
    List<Map> RechargeQuery(Map map);
    /**
     * 分页数量
     * @return
     */
    int RechargeGetPageCount();
    /**
     * 充值
     * @return
     */
    int RechargeAdd(Map map);

}
