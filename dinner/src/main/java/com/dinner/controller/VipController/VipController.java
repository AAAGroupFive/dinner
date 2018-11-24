package com.dinner.controller.VipController;

import com.dinner.service.VipService.VipService;
import com.dinner.util.PageUntil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * className:VipController
 * discription:
 * author:panjing
 * createTime:2018-11-23 15:45
 */
@Controller
public class VipController {
    @Autowired
    private VipService vipService;

    @RequestMapping("/toVip")
    public String toVip(){
        return "after/vipQuery";
    }

    @RequestMapping("/VipQuery")
    @ResponseBody
    public Object VipQuery(Map map, HttpServletRequest request){
        Map temp=new HashMap();
        map.put("pageSize",5);
        int pageNo = map.get("pageNo") == null ? 1 : Integer.valueOf(map.get("pageNo") + "");
        String stringPage = new PageUntil(pageNo, 5, vipService.VipQuery(map), vipService.VipGetPageCount(), request).getStringPage();
        temp.put("code",0);
        temp.put("msg","");
        temp.put("count",vipService.VipGetPageCount());
        temp.put("data",vipService.VipQuery(map));

        return temp;
    }
}
