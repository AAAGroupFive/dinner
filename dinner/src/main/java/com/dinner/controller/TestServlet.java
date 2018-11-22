package com.dinner.controller;

import com.dinner.service.test;
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
    private test test;

    @RequestMapping("/test")
    public String test(){
        return "after/index";
    }

    /**
     * 列表
     */


    @RequestMapping("/emplist")
    public String emplist( Map map){
        System.out.println(test.getList(map));
        return "after/index";
    }
}
