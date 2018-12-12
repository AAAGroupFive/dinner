package com.dinner.controller.goodsController;


import com.dinner.service.goodsService.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @RequestMapping("/toDetails")
    public String toDetails(){
        return "after/details";
    }
    @RequestMapping("/toInventory")
    public String toInventory(){
        return "after/inventory";
    }
    @RequestMapping("/toInventory-list")
    public String toInventorylist(){
        return "after/inventory-list";
    }
    @RequestMapping("/toPut-record")
    public String toPutrecord(){
        return "after/put-record";
    }
    @RequestMapping("/toPut-goods")
    public String toPutgoods(){
        return "after/put-goods";
    }
    @RequestMapping("/goodsList")
    @ResponseBody
    public Object getOrderList(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("count",goodsService.countFoodsList());
        tempMap.put("data",goodsService.goodsList(map));
        return tempMap;
    }
    @RequestMapping("/inventoryList")
    @ResponseBody
    public Object inventoryList(@RequestParam Map map){
        //PageHelper.startPage(Integer.valueOf(map.get("pageNo")+""),Integer.valueOf(map.get("pageSize")+""));
        //PageInfo<Map> page =new PageInfo<Map>(goodsService.inventoryList(map));
       // System.out.println(page+"222222222222222222");
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("data",goodsService.inventoryList(map));
        //tempMap.put("total",page.getTotal());
        return tempMap;
    }
    @RequestMapping("/putGoodsList")
    @ResponseBody
    public Object putGoodsList(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("count",goodsService.countPutList());
        tempMap.put("data",goodsService.putGoodsList(map));
        return tempMap;
    }
    @RequestMapping("/putRecord")
    @ResponseBody
    public Object putRecord(@RequestParam Map map){
        Map tempMap = new HashMap();
        //绑定数据  分页数据
        tempMap.put("code", 0);
        tempMap.put("msg", "");
        tempMap.put("count",goodsService.countPutRecordList());
        tempMap.put("data",goodsService.putRecord(map));
        return tempMap;
    }
    @ResponseBody
    @RequestMapping("/inventoryDetails")
    public Object inventoryDetails(@RequestParam Map map){
        List<Map> aaa = goodsService.inventoryDetails(map);
        return aaa;
    }
    @RequestMapping("/updateInventory")
    @ResponseBody
    public Object updateInventory(@RequestParam Map map){
        int result =goodsService.updateInventory(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }
    @RequestMapping("/addPutGoods")
    @ResponseBody
    public Object addPutGoods(@RequestParam Map map){
        int result =goodsService.addPutGoods(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }
    @RequestMapping("/addPutRecord")
    @ResponseBody
    public Object addPutRecord(@RequestParam Map map){
        int result =goodsService.addPutRecord(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }
    @RequestMapping("/addPutRecord2")
    @ResponseBody
    public Object addPutRecord2(@RequestParam Map map){
        int result =goodsService.addPutRecord2(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }
    //1231231


}
