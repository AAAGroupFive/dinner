package com.dinner.service.emp;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-10:12
 */
public interface EmpService {

    /***
     * 雇员列表
     * @param map
     * @return
     */
    List<Map> getEmp(Map map);

    /**
     * 雇员分页
     * @param map
     * @return
     */
    int getCountEmp(Map map);
}