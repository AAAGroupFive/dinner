package com.dinner.controller.RechargeController;

import com.dinner.service.RechargeService.RechargeSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * className:RechargeController
 * discription:
 * author:panjing
 * createTime:2018-12-03 13:56
 */
@Controller
@RequestMapping("/RECHARGE")
public class RechargeController {
    @Autowired
    private RechargeSerive rechargeSerive;

    /**
     * 跳转到充值记录表
     * @return
     */
    @RequestMapping("/toVipRecharge")
    public  String toVipRecharge(){
        return "after/vipRecharge";
    }
    /**
     * 查询充值记录列表
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/VipRechargeQuery")
    @ResponseBody
    public Map VipRechargeQuery(@RequestParam Map map, HttpServletRequest request){
        System.out.println(map);

        Map temp=new HashMap();

        temp.put("code",0);
        temp.put("msg","");
        temp.put("count",rechargeSerive.RechargeGetPageCount());
        temp.put("data",rechargeSerive.RechargeQuery(map));
        return temp;

    }
    /**
     * 充值
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/VipRechargeAdd")
    @ResponseBody
    public int VipRechargeAdd(@RequestParam Map map, HttpServletRequest request){

        System.out.println(map);
        HttpSession session = request.getSession();
        session.setAttribute("name","admin");
        Object name = session.getAttribute("name");
        map.put("Empname",name);


        return rechargeSerive.RechargeAdd(map);

    }

}
