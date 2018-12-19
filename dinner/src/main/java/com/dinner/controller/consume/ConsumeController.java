package com.dinner.controller.consume;

import com.dinner.service.consume.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:ConsumeController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-19 10:51
 */
@Controller
public class ConsumeController {

    @Autowired
    private ConsumeService consumeService;

    /**
     * 跳转到消费单页面
     * @return
     */
    @RequestMapping("/toConsume")
    public String toConsume() {
        return "after/consume";
    }

    @ResponseBody
    @RequestMapping("/consume")
    public Map consume() {
        Map map = new HashMap();
        map.put("data", consumeService.consumeList());
        return map;
    }
}
