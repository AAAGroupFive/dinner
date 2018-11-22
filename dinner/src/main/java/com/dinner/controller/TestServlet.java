package com.dinner.controller;

import com.dinner.service.testImpl;
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

    @Autowired
    private testImpl test;

    @RequestMapping("/test")
    public String test(Map map){
        System.out.println(test.getList(map));
        return "after/index";
    }
}
