package com.dinner.controller.tableController;

import com.dinner.service.orderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:BeginTableController
 * describe:
 * author:邢芳彬
 * createTime:2018-11-23 20:43
 */
@Controller
@RequestMapping("/order")
public class BeginTableController {

    @Autowired
    private OrderService orderService;

    /**
     * 跳转到开桌页面
     * @return
     */
    @RequestMapping("/begin")
    public String begin(String number, Model model) {
        model.addAttribute("number", number);
        return "after/begin-table2";
    }

    @RequestMapping("/food")
    public String food() {
        return "after/food";
    }

    /**
     * 获取开单时商品列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/goodsList")
    public Map goodsList() {
        Map tempMap = new HashMap();
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",orderService.goodList());
        return tempMap;
    }

    /**
     * 生成消费记录
     * @param map
     */
    @ResponseBody
    @RequestMapping("/order")
    public void order(@RequestParam Map map) {
        /*String orderIds = (String) map.get("orderIds");
        String[] sp = orderIds.split(",");
        List list = new ArrayList();
        for (int i = 0; i < sp.length; i++) {
            list.add(i, sp[i]);

        }*/
        //System.out.println(list);
        System.out.println(map);
        /*int number = (int) map.get("number");
        orderService.update(number);*/
        orderService.order(map/*,list*/);
    }

    /**
     * 跳转到增加消费页面
     * @return
     */
    @RequestMapping("/addGoods")
    public String addGoods() {
        return "after/addGoods";
    }
}
