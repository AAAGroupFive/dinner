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
    public String food(String number, Model model) {
        model.addAttribute("number", number);
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
     * 开桌
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/order")
    public Object order(@RequestParam Map map) {
        orderService.update(map);
        orderService.order(map);
        return map;
    }

    /**
     * 点菜
     * @param map
     * @return
     */
    @RequestMapping("/choose")
    public String aaa(@RequestParam Map map) {
        String orderIds = (String) map.get("ids");
        String num = (String) map.get("number");
        String[] sp = orderIds.split(",");
        List<Map> list = new ArrayList();
        Map tmap =null;
        for (int i = 0; i < sp.length; i++) {
            tmap =new HashMap();
            tmap.put("id",sp[i]);
            tmap.put("num",num);
            list.add(tmap);
        }
        orderService.insertChoose(list);
        return "after/welcome";
    }


}
