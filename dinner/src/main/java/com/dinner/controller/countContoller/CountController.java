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
import java.util.List;
import java.util.Map;

/**
 * className:countController
 * describe:
 * author:邢芳彬
 * createTime:2018-12-04 16:40
 */
@Controller
@RequestMapping("/count")
public class CountController {

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

    /**
     * 消费详情
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/countDetails")
    public Map countDetails(@RequestParam Map map) {
        Map tempMap = new HashMap();
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",orderService.countDetails(map));
        return tempMap;
    }

    /**
     * 消费总计
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/sum")
    public int sum(@RequestParam Map map) {
        List<Map> maps = orderService.countDetails(map);
        int sum = 0;
        for (int i = 0; i < maps.size(); i++) {
            Integer food_price = Integer.valueOf(maps.get(i).get("FOOD_PRICE") + "");
            sum+=food_price;
        }
        return sum;
    }

    /**
     * 关闭桌子
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/close")
    public int close(@RequestParam Map map) {
        String o = (String) map.get("sum");
        int sum = Integer.valueOf(o);
        if (map.get("vip") != null && map.get("vip")!="") {
            System.out.println(map.get("vip"));
            int checkMoney = orderService.checkMoney(map);
                if (checkMoney < sum) {
                    return 0;
                } else {
                    return orderService.vip(map);
                }

        }
        orderService.close(map);
        return orderService.closeTable(map);
    }
}
