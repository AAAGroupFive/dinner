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
    @RequestMapping("/toVipQuery")
    public String toVipQuery(){
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
        System.out.println(map);

        Map temp=new HashMap();


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
    public Map VipAdd(@RequestParam Map map){
        Object viPname = map.get("VIPname");
        Object viPcard = map.get("VIPcard");

        int i = vipService.VipAdd(map);


        Map temp=new HashMap();

        if(i>-1){
            temp.put("issuc",true);
        }else{
            temp.put("issuc",false  );
        }




        return temp ;



    }

    /**
     * 会员更新
     * @return
     */
    @ResponseBody
    @RequestMapping("/VipUpdate")
    public Map  VipUpdate(@RequestParam Map map){
        System.out.println(map);

        int i = vipService.VipUpdate(map);
        Map temp=new HashMap();

            temp.put("issuc",i);



        return temp ;
    }

    /**
     * 会员删除
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/VipDelete")
    public int VipDelete(@RequestParam Map map){
        System.out.println(map);


        return  vipService.VipDelete(map);
    }
    @ResponseBody
    @RequestMapping("/State")
    public int State(@RequestParam Map map){
        System.out.println(map);


        return  1;
    }

}
