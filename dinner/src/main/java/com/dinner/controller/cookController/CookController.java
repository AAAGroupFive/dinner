package com.dinner.controller.cookController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dinner.service.cookService.cookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * className:cookController
 * discriptoin:
 * author:王朝军
 * createTime:2019-01-11 21:23
 */
@Controller
public class CookController {
    @Autowired
    private cookService cookService;
    @RequestMapping("/toCookList")
    public String toCookList(){
        return "after/cook";
    }
    @RequestMapping("/cookList")
    @ResponseBody
    public Object cookList(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
//        tempMap.put("count",goodsService.countFoodsList());
        tempMap.put("data",cookService.cookList(map));
        return tempMap;
    }
    @RequestMapping("/cookedList")
    @ResponseBody
    public Object cookedList(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
 //       tempMap.put("count",goodsService.countFoodsList());
        tempMap.put("data",cookService.cookedList(map));
        return tempMap;
    }
    @RequestMapping("/updateCook")
    @ResponseBody
    public Object updateCook(@RequestParam Map map){
        int result =cookService.updateCook(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }
}
