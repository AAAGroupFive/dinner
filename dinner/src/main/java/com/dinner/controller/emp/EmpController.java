package com.dinner.controller.emp;

import com.dinner.service.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object getEmp(@RequestParam Map map){
        List<Map> emp = empService.getEmp(map);
        int countEmp = empService.getCountEmp(map);
        //System.out.println(countEmp);
        Map map1 = new HashMap();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",countEmp);
        map1.put("data",emp);
        return map1;
    }
}
