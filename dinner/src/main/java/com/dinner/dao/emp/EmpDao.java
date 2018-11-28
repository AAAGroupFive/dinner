package com.dinner.dao.emp;


import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-10:05
 */
public interface EmpDao {

    /**
     * 雇员列表
     * @param map
     * @return
     */
    List<Map> getEmp(Map map);

    /**
     * 雇员数量
     * @return
     */
    //@Select("select count(*) as cnt from tab_emp")
    int getCountEmp();

    /***
     * 雇员添加
     * @param map
     * @return
     */
    int addEmp(Map map);

    /**
     *
     * @param empId
     * @return
     */
    int updateEmp(int empId);
}
