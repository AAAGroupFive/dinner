package com.dinner.service.power;

import com.dinner.dao.power.PowerDao;
import com.dinner.entity.Emp;
import com.dinner.entity.Tree;
import com.dinner.entity.TreeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:PowerServiceImpl
 * discriptoin:
 * author:zz
 * createTime:2018-12-10-16:26
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerDao powerDao;

    @Override
    public List<TreeRole> getList() {
        List<TreeRole> list = powerDao.getList();
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
    public List<Tree> getRole(Map map) {
        return powerDao.getRole(map);
    }

    @Override
    public int add(Map map) {
        String str = (String) map.get("ids");
        //System.out.println(str);
        //System.out.println(map.get("roleId"));
        Integer roleId = Integer.valueOf(map.get("roleId")+"");
        //System.out.println(roleId);
        String[] strArray = str.split(",");
        List<Map> list= new ArrayList();
        Map tempMap = null;
        for(int i=0;i<strArray.length;i++){
            tempMap =new HashMap();
            tempMap.put("pid", strArray[i]);
            tempMap.put("roleId",roleId);
            list.add(tempMap);
        }
        //System.out.println(list);
        return powerDao.add(list);
    }

    @Override
    public List<Emp> getEmp(Map map) {
        return powerDao.getEmp(map);
    }

    @Override
    public int getPageCount(Map map) {
        return powerDao.getPageCount(map);
    }

    @Override
    public int delFun(int id) {
        return powerDao.delFun(id);
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
