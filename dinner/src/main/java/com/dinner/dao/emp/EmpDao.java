package com.dinner.dao.emp;

import org.apache.ibatis.annotations.Select;

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
    //@Select("select EMP_ID as empId,EMP_NAME as EmpName,EMP_USER as userName,EMP_PASS as password,EMP_SEX as sex,EMP_AGE as age,EMP_PHONE as phone,EMP_ADDR as addr,EMP_ROLE as role from tab_emp")
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
}
