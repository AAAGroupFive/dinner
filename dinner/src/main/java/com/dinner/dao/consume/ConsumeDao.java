package com.dinner.dao.consume;

import java.util.List;
import java.util.Map;

/**
 * className:ConsumeDao
 * describe:
 * author:邢芳彬
 * createTime:2018-12-19 11:19
 */
public interface ConsumeDao {

    /**
     * 消费单列表
     * @return
     */
    List<Map> consumeList();
}
