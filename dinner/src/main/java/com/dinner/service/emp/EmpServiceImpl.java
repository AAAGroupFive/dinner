package com.dinner.service.emp;

import com.dinner.dao.emp.EmpDao;
import com.dinner.entity.TreeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-10:13
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public List<Map> getEmp(Map map) {
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        int pageSize = map.get("pageSize") == null ? 10 : Integer.valueOf(map.get("pageSize") + "");
        map.put("start",(pageNo-1)*pageSize);

        map.put("end",pageNo*pageSize+1);


        return empDao.getEmp(map);
    }

    @Override
    public int getCountEmp() {
        return empDao.getCountEmp();
    }

    @Override
    public int addEmp(Map map) {
        return empDao.addEmp(map);
    }

    @Override
    public int delEmp(int empId) {
        return empDao.delEmp(empId);
    }

    @Override
    public int updateEmp(Map map) {
        return empDao.updateEmp(map);
    }

    @Override
    public List<Map> findByid(int id) {
        return empDao.findByid(id);
    }

    @Override
    public List<Map> login(Map map) {
        return empDao.login(map);
    }

    @Override
    public List<Map> getRole(Map map) {
        return empDao.getRole(map);
    }

    @Override
    public List<TreeRole> roleList(int id) {
        List<TreeRole> list = empDao.roleList(id);
        List<TreeRole> treeNodesList = new ArrayList<TreeRole>();
        if(list!=null&&list.size()>0){
            for (TreeRole treeNode : list) {
                //一级菜单
                if(treeNode.getPid()==0){
                    treeNodesList.add(treeNode);
                    //循环绑定子节点
                    bindChirdren(treeNode,list);
                }
            }
        }
        return treeNodesList;
    }

    @Override
    public List<Map> perInfo(int empId) {
        return empDao.perInfo(empId);
    }

    @Override
    public int perUpdate(Map map) {
        return empDao.perUpdate(map);
    }

    /**
     * 递归绑定子节点
     * @param treeNode
     * @param treeNodesList
     */
    public void bindChirdren(TreeRole treeNode,List<TreeRole> treeNodesList){
        for (TreeRole node : treeNodesList) {
            if(node.getPid()==treeNode.getId()){
                List<TreeRole> children = treeNode.getChildren();
                if(children==null){
                    children=new ArrayList<TreeRole>();
                }
                children.add(node);
                treeNode.setChildren(children);
                //递归调用自己
                bindChirdren(node,treeNodesList);
            }
        }
    }
}
