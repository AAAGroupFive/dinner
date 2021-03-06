package com.dinner.controller.emp;

import com.dinner.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * discriptoin:
 * author:zz
 * createTime:2018-11-23-10:15
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/toList")
    public String ToIndex(){
        return "after/userlist";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "after/userAdd1";
    }

    @RequestMapping("/toTest")
    public String toTest(){
        return "after/test";
    }

    @RequestMapping("/toPer")
    public String toPer(){
        return "after/PerInformation";
    }

    /**
     * 员工列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object getEmp(@RequestParam Map map){//g
        //System.out.println(1111);
        //System.out.println(map.get("ename"));
        List<Map> emp = empService.getEmp(map);
        int countEmp = empService.getCountEmp();
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",countEmp);
        tempMap.put("data",emp);
        return tempMap;
    }

    /**
     * 员工添加
     * @param map
     * @return
     */
    @RequestMapping("/add")
    public Object empAdd(@RequestParam Map map){
        //System.out.println("QAQ`");
        //System.out.println(map);
        int i = empService.addEmp(map);
        if (i>0){
            return "after/userlist";
        }else {

            return "after/userAdd1";
        }
    }

    /**
     * 员工删除
     * @param EMPID
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public Object empDel(@RequestParam int EMPID){
        int result = empService.delEmp(EMPID);
        Map tempMap = new HashMap();
        if (result==1){
            tempMap.put("issuc",true);
        }else {
            tempMap.put("issuc", false);
        }
        return tempMap;
    }

    /**
     * 员工修改
     * @param map
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Object empUpdate(@RequestParam Map map){
        //System.out.println(map);
        int result = empService.updateEmp(map);
        Map tempMap = new HashMap();
        if (result==1){
            tempMap.put("issuc",true);
        }else {
            tempMap.put("issuc", false);
        }
        return tempMap;
    }

    /**
     * 个人信息
     * @param session
     * @return
     */
    @RequestMapping("/perInfo")
    @ResponseBody
    public Object perInfor(HttpSession session){
        //System.out.println(session.getAttribute("userName"));
        Integer empId = Integer.valueOf(session.getAttribute("empId")+"");
        //System.out.println(empId);
        if (empId!=null){
            List<Map> maps = empService.perInfo(empId);
            //System.out.println(maps);
            return maps;
        }
        return null;
    }

    /**
     * 个人信息修改
     * @param map
     * @return
     */
    @RequestMapping("perUpdate")
    @ResponseBody
    public Object perUpdate(@RequestParam Map map){
        //System.out.println(map);
        if (map!=null&&map.size()>0){
            empService.perUpdate(map);
        }
        return null;
    }

    /**
     * 唯一性校验
     * @return
     */
    @RequestMapping("/user")
    @ResponseBody
    public Object checkUser(@RequestParam Map map){
        //System.out.println(map.get("userName"));
        if (map!=null&&map.size()>0){
            List<Map> maps = empService.checkUser(map);
            if (maps!=null&&maps.size()>0){
                return 1;
            }else{
                return 0;
            }
        }

        return null;
    }

}
