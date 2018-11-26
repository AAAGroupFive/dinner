package com.dinner.controller.VipController;


import com.dinner.service.VipService.VipService;
import com.dinner.util.PageUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:VipController
 * discription:
 * author:panjing
 * createTime:2018-11-23 15:45
 */
@Controller
@RequestMapping("/VIP")
public class VipController {
    @Autowired
    private VipService vipService;

    @ResponseBody
    @RequestMapping("/GetSession")
    public Map GetSession(Model model, HttpServletRequest request){

        Map temp=new HashMap();
        HttpSession session = request.getSession();
            session.setAttribute("name","admin");
        Object name = session.getAttribute("name");
       temp.put("Empname",name);
        return temp;
    }
    /**
     * 去会员查询页面
     * @return
     */
    @RequestMapping("/toVip")
    public String toVip(){
        return "after/vipQuery";
    }

    /**
     * 查询会员列表
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/VipQuery")
    @ResponseBody
    public Map VipQuery(@RequestParam Map map, HttpServletRequest request){

        Map temp=new HashMap();
        map.put("pageSize",5);

        System.out.println("VipQuery"+vipService.VipQuery(map));
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        String stringPage = new PageUntil(pageNo, 5, vipService.VipQuery(map), vipService.VipGetPageCount(), request).getStringPage();
        temp.put("code",0);
        temp.put("msg","");
        temp.put("count",vipService.VipGetPageCount());
        temp.put("data",vipService.VipQuery(map));
        return temp;

    }

    /**
     * 添加会员
     * @param map
     * @return
     */


    @ResponseBody
    @RequestMapping("/VipAdd")
    public Object VipAdd(@RequestParam Map map){
        Object viPname = map.get("VIPname");
        Object viPcard = map.get("VIPcard");

        int i = vipService.VipAdd(map);

        Map map1 = new HashMap();
        if(i>0){
            map1.put("viPname",viPname);
            map1.put("viPcard",viPcard);
            map1.put("msg",i);

        }


        return map1;
    }

    /**
     * 会员更新
     * @return
     */
    @RequestMapping("/VipUpdate")
    public String VipUpdate(@RequestParam Map map){

        return "after/CheckCar";
    }

    @RequestMapping("/VipDelet")
    public String VipDelet(@RequestParam Map map){

        return "after/CheckCar";
    }

}
