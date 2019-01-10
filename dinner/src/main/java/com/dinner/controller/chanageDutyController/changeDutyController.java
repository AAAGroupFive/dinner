package com.dinner.controller.chanageDutyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dinner.service.changeDutyService.changeDutyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:changeDutyController
 * discription:
 * author:panjing
 * createTime:2018-12-05 14:35
 */
@Controller
@RequestMapping("/changeDuty")
public class changeDutyController {

    @Autowired
    private changeDutyService changeDutyService;

    /**
     * 跳转到交班页面
     * @return
     */
    @RequestMapping("/tochangeduty")
    public String tochangeduty(){

        return "after/changeduty";
    }
    /**
     * 跳转到交班纪录页面
     * @return
     */
    @RequestMapping("/tochangedutyRecord")
    public String tochangedutyRecord(){

        return "after/changedutyRecord";
    }

    /**
     * 查询交班所需要的信息
     * @param
     * @return
     */
    @RequestMapping(value = "/queryChangeDuty")
    @ResponseBody
    public Map ChangeDuty(HttpServletRequest request){
        HttpSession session = request.getSession();


        Object name = session.getAttribute("userName");

        Map queryChangeDuty = changeDutyService.queryChangeDuty();
        queryChangeDuty.put("cEmp",name);

        return queryChangeDuty;
    }

    /**
     * 查询交班所需要的接班员工信息
     * @param
     * @return
     */
    @RequestMapping(value = "/queryJemp")
    @ResponseBody
    public List<Map> ChangeDuty1(){


        return changeDutyService.queryJemp();
    }

    /**
     * 保存交班记录
     * @param map
     */
    @RequestMapping(value = "/saveChangeDuty")
    @ResponseBody
    public int saveChangeDuty(@RequestBody Map map ){


        int insert = changeDutyService.insert(map);

        return insert ;

    }
    /**
     * 查询交班记录
     *
     */
    @RequestMapping(value = "/queryRecord")
    @ResponseBody
    public List<Map> queryRecord(){

        List<Map> map = changeDutyService.queryRecord();


        return map ;

    }


}
