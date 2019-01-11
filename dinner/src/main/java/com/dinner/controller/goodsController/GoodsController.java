package com.dinner.controller.goodsController;


import com.dinner.service.goodsService.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    /**
     * 菜品列表
     * @param map
     * @return
     */
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

    /**
     * 盘点列表
     * @param map
     * @return
     */
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

    /**
     * 进货列表
     * @param map
     * @return
     */
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

    /**
     * 进货记录
     * @param map
     * @return
     */
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

    /**
     * 盘点详情
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/inventoryDetails")
    public Object inventoryDetails(@RequestParam Map map){
        List<Map> aaa = goodsService.inventoryDetails(map);
        return aaa;
    }

    /**
     * 更新盘点列表
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/updateInventory")
    @ResponseBody
    public Object updateInventory(@RequestParam Map map, HttpSession session){
        Object userName = session.getAttribute("userName");
        map.put("Account",userName);
        //System.out.println("在控制层获取了session"+userName);
        int result =goodsService.updateInventory(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }

    /**
     * 需要添加商品
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/addPutGoods")
    @ResponseBody
    public Object addPutGoods(@RequestParam Map map,HttpSession session){
        Object userName = session.getAttribute("userName");
        map.put("Account",userName);
        int result =goodsService.addPutGoods(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }

    /**
     * 成功记录
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/addPutRecord")
    @ResponseBody
    public Object addPutRecord(@RequestParam Map map,HttpSession session){
        Object userName = session.getAttribute("userName");
        map.put("Account",userName);
        int result =goodsService.addPutRecord(map);
        Map tempMap = new HashMap();
        if (result==-1) {
            tempMap.put("issuc", false);
        }else {
            tempMap.put("issuc", true);
        }
        return tempMap;
    }

    /**
     * 失败记录
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/addPutRecord2")
    @ResponseBody
    public Object addPutRecord2(@RequestParam Map map,HttpSession session){
        Object userName = session.getAttribute("userName");
        map.put("Account",userName);
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
