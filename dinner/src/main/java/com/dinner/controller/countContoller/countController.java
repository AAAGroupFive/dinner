package com.dinner.controller.countContoller;

import com.dinner.service.orderService.OrderService;
import com.dinner.service.orderService.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    @Autowired
    private OrderService orderService;

    /**
     * 结账页面
     * @return
     */
    @RequestMapping("/count")
    public String Count(@RequestParam Map map, Model model) {
        model.addAttribute("number", map.get("number"));
        return "after/count";
    }

    /**
     * 消费记录
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/countHistory")
    public Map countHistory(@RequestParam Map map) {
        Map tempMap = new HashMap();
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",orderService.countHistory(map));
        return tempMap;
    }

    @ResponseBody
    @RequestMapping("/countDetails")
    public Map countDetails(@RequestParam Map map) {
        Map tempMap = new HashMap();
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",orderService.countDetails(map));
        return tempMap;
    }
}
