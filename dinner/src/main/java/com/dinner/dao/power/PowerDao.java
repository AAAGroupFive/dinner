package com.dinner.dao.power;

import com.dinner.entity.Emp;
import com.dinner.entity.Tree;
import com.dinner.entity.TreeRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:PowerDao
 * discriptoin:
 * author:zz
 * createTime:2018-12-04-15:38
 */
public interface PowerDao {

    /**
     * 权限列表
     * @return
     */
    @Select("select t.id,t.fun_name label,t.pid pid,t.fun_ms className,t.fun_url url,t.fid from tab_function t ")
    List<TreeRole> getList();

    /**
     * 用户权限列表
     * @return
     */
    @Select("select role_Id as roleId,fun_id as funId from role_fun where role_id=#{roleId}")
    List<Tree> getRole(Map map);

    /**
     * 雇员表
     * @return
     */
    @Select({"<script>select * from (select rownum rn,t.emp_id as empId,t.emp_name as EmpName,t.emp_user as userName,t.emp_pass as passWord,t.emp_phone as phone,t.emp_role as role from tab_emp t <where>" +
            "<if test=\"end!=null and end!=''\"> and rownum &lt; #{end} </if>" +
            "<if test=\"userName!=null and userName!=''\"> and emp_user like '%'||#{userName}||'%' </if>" +
            "<if test=\"phone!=null and phone!=''\"> and emp_phone like '%'||#{phone}||'%' </if> "  +
            "</where>) a where a.rn &gt; #{start}</script>"})
    List<Emp> getEmp(Map map);

    /**
     * 插叙分页总数量
     * @param map
     * @return
     */
    @Select({"<script>" +"select count(*) from tab_emp <where>" +
            "<if test=\"userName!=null and userName!=''\"> and emp_user like '%'||#{userName}||'%' </if>" +
            "<if test=\"phone!=null and phone!=0\"> and emp_phone like '%'||#{phone}||'%' </if>" +
            "</where></script>"})
    int getPageCount(Map map);

    /**
     * 批量添加
     * @param map
     * @return
     */
    @Insert({"<script>"
            +"insert into role_fun "
            +"<foreach item='map' collection='list' separator='union'>"
            +" select #{map.roleId},#{map.pid} from dual "
            +"</foreach>"
            +"</script>"})
    int add(List<Map> map);

    /**
     * 清除该id的权限
     * @param id
     * @return
     */
    @Delete("delete from role_fun where role_id=#{id}")
    int delFun(int id);
}
