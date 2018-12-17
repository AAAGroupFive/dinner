package com.dinner.controller.emp;

import com.dinner.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/list")
    @ResponseBody
    public Object getEmp(@RequestParam Map map){//g
        //System.out.println(1111);
        System.out.println(map.get("ename"));
        List<Map> emp = empService.getEmp(map);
        int countEmp = empService.getCountEmp();
        Map tempMap = new HashMap();
        tempMap.put("code",0);
        tempMap.put("msg","");
        tempMap.put("count",countEmp);
        tempMap.put("data",emp);
        return tempMap;
    }


    @RequestMapping("/add")
    @ResponseBody
    public Object empAdd(@RequestParam Map map){
        //System.out.println("QAQ`");
        System.out.println(map);
        return empService.addEmp(map);
    }

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
}
