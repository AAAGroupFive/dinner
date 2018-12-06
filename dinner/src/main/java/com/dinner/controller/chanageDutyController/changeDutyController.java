package com.dinner.controller.chanageDutyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Client;

import java.util.HashMap;
import java.util.Map;

/**
 * className:changeDutyController
 * discription:
 * author:panjing
 * createTime:2018-12-05 14:35
 */
@Controller
@RequestMapping("/changeDuty")
public class changeDutyController {


    /**
     * 跳转到交班页面
     * @return
     */
    @RequestMapping("/tochangeduty")
    public String tochangeduty(){
        return "after/changeduty";
    }

    @RequestMapping(value = "/addChangeDuty")
    @ResponseBody
    public String addChangeDuty(@RequestBody Client map){
        System.out.println(map);
        Map temp = new HashMap();
        temp.put("issuc","成功");
        return "temp";
    }
}
