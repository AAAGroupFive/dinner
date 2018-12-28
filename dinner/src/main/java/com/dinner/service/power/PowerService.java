package com.dinner.service.power;

import com.dinner.entity.Emp;
import com.dinner.entity.Tree;
import com.dinner.entity.TreeRole;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * className:PowerService
 * discriptoin:
 * author:zz
 * createTime:2018-12-10-16:25
 */
public interface PowerService {
    /**
     * 权限列表
     * @return
     */
    List<TreeRole> getList();

    /**
     * 用户权限
     * @return
     */
    List<Tree> getRole(Map map);

    /**
     * 批量添加
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 雇员表
     * @return
     */
    List<Emp> getEmp(Map map);

    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 清除该id的权限
     * @param id
     * @return
     */
    int delFun(int id);
}
