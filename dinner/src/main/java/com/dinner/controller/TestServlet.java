package com.dinner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * className:TestServlet
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 10:56
 */
@Controller
public class TestServlet {


    @RequestMapping("/test")
    public String test(){
        return "after/index";
    }
}
