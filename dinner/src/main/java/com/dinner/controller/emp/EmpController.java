package com.dinner.controller.emp;

import com.dinner.service.emp.EmpService;
import com.dinner.util.PageUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/list")
    @ResponseBody
    public Object getEmp(@RequestParam Map map){//g
        
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
        System.out.println("QAQ`");
        System.out.println(map);
        return null;
    }
}
