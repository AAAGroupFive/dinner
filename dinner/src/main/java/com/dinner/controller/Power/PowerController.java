package com.dinner.controller.Power;

import com.dinner.entity.Emp;
import com.dinner.entity.Tree;
import com.dinner.entity.TreeRole;
import com.dinner.service.power.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:PowerController
 * discriptoin:
 * author:zz
 * createTime:2018-12-10-16:28
 */
@Controller
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @RequestMapping("/toRole")
    public String role(){
        return "after/role";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/toList")
    public String getList(){
        return "after/rolelist";
    }

    /**
     * 列表数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object list(){
        //System.out.println(powerService.getList());
        return powerService.getList();
    }

    /**
     * 雇员列表
     * @param map
     * @return
     */
    @RequestMapping("/empList")
    @ResponseBody
    public Object empList(@RequestBody Map map){
        //System.out.println(map.get("userName"));
        //System.out.println(map+".................");
        List<Emp> emp = powerService.getEmp(map);
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getRole().equals("0"))
                emp.get(i).setRole("服务员");
            else if (emp.get(i).getRole().equals("1"))
                emp.get(i).setRole("收银");
            else if (emp.get(i).getRole().equals("2"))
                emp.get(i).setRole("仓库");
            else if (emp.get(i).getRole().equals("3"))
                emp.get(i).setRole("老板");
        }
        //System.out.println(map.get("start"));
        //System.out.println(map.get("end"));
        int pageCount = powerService.getPageCount(map);
        Map tempMap = new HashMap();
        tempMap.put("data",emp);
        tempMap.put("total",pageCount);
        return tempMap;
    }

    /**
     * 批量添加角色权限关联表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Map map){
        //System.out.println(map.get("ids")+"----"+map.get("roleId"));
        //System.out.println(map.get("roleId"));
        int id = Integer.valueOf(map.get("roleId")+"");
        System.out.println(id);
        int i = powerService.delFun(id);
        if (i>0){
            System.out.println("权限清除成功！！");
        }else {
            System.out.println("权限清除失败！！");
        }
        //powerService.delFun();
        return    powerService.add(map);
    }

    /**
     * 删除该用户
     * @param empId
     * @return
     */
    @ResponseBody
    @RequestMapping("/del")
    public Object del(@RequestParam int empId){
        //System.out.println(empId);
        return 1;
    }

    /**
     * 权限表数据
     * @return
     */
    @RequestMapping("/role")
    @ResponseBody
    public Object roleList(@RequestBody Map map){
        //System.out.println(map.get("roId"));
        List<Tree> role = powerService.getRole(map);
        //System.out.println(role);
        return role;
    }

    /**
     * 列表数据
     * @return
     */
    //@ResponseBody
    @RequestMapping("/index")
    public String indexList(Model model){
        //System.out.println(powerService.getList());
        List<TreeRole> list = powerService.getList();
        System.out.println(list.get(0).getChildren().get(0).getLabel());
        System.out.println(list.get(0).getLabel());
        //System.out.println(list);
        model.addAttribute("menuList",list);
        //System.out.println(list.get(0));
        return "after/index";
    }
}
