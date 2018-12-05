package com.dinner.dao.projectCountDao;

import java.util.List;
import java.util.Map;

/**
 * className:ProjoectCountDao
 * discription:
 * author:panjing
 * createTime:2018-11-29 17:06
 */

public interface ProjoectCountDao {

    /**
     * 每月财务统计
     *
     * @return
     */
    List<Map> getMoneyCount();
}
