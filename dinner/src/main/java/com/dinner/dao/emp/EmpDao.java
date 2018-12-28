package com.dinner.dao.emp;


import com.dinner.entity.TreeRole;
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
     * 删除雇员
     * @param empId
     * @return
     */
    int delEmp(int empId);

    /**
     *
     * @param map
     * @return
     */
    int updateEmp(Map map);

    /**
     * 雇员
     * @return
     */
    List<Map> findByid(int id);

    /**
     * 验证
     * @param map
     * @return
     */
    List<Map> login(Map map);

    /**
     *
     * @param map
     * @return
     */
    List<Map> getRole(Map map);

    @Select("select f.id,f.fun_name label,f.pid pid,f.fun_url url from role_fun r,tab_function f,tab_emp e where r.fun_id=f.id and r.role_id=e.emp_id and r.role_id=#{id} and e.emp_power like 'user:%'")
    List<TreeRole> roleList(int id);
}
