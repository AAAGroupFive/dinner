package com.dinner.controller.goodsController;


import com.dinner.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:GoodsController
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-22 20:53
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/toList")
    public String tologin(Map map){
        List<Map> maps = goodsService.goodsList(map);
        System.out.println(maps);
        return "after/inventory";
    }
    @RequestMapping("/goodsList")
    @ResponseBody
    public Object getOrderList(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",goodsService.goodsList(map));
        return tempMap;
    }
}
