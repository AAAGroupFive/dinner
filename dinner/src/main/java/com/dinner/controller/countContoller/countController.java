package com.dinner.controller.countContoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * className:countController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-04 16:40
 */
@Controller
@RequestMapping("/count")
public class countController {

    /**
     * 结账页面
     * @return
     */
    @RequestMapping("/count")
    public String Count(@RequestParam Map map) {
        System.out.println(map.get("number"));
        return "after/count";
    }
}
