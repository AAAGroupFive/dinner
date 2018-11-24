package com.dinner.controller.tableController;

import com.dinner.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    private GoodsService goodsService;

    /**
     * 跳转到开桌页面
     * @return
     */
    @RequestMapping("/begin")
    public String begin(String number, Model model) {
        model.addAttribute("number", number);
        return "after/begin-table";
    }

    @RequestMapping("/goodsList")
    public Map goodsList(Map map) {
        List<Map> maps = goodsService.goodsList(map);
        map.put("goodsId", maps.get(0).get("GOODSID"));
        System.out.println(map);
        return map;
    }
}
