package com.dinner.controller.chanageDutyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:changeDutyController
 * discription:
 * author:panjing
 * createTime:2018-12-05 14:35
 */
@Controller
@RequestMapping("/changeDuty")
public class changeDutyController {


    @RequestMapping("tochangeduty")
    public String tochangeduty(){
        return "after/changeduty";
    }
}
