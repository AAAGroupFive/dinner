package com.dinner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className:TestServlet
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 10:56
 */
@Controller
@RequestMapping("/test")
public class TestServlet {
    @RequestMapping("/test")
    public String test(){
        return "after/index";
    }
}
