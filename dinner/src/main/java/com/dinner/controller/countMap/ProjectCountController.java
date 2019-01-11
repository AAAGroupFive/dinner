package com.dinner.controller.countMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dinner.service.projectCountService.ProjectCountService;

import java.util.List;
import java.util.Map;

/**
 * className:projectCountController
 * discription:
 * author:panjing
 * createTime:2018-11-29 17:03
 */
@Controller
@RequestMapping("/projectCount")
public class ProjectCountController {
    @Autowired
    private ProjectCountService projectService;

    /**
     *跳转到营业额图表统计页面
     */

    @RequestMapping("/toVipCount")
    public String toVipCount(){
        return "after/countVipMap";
    }
    /**
     *跳转到营业额图表统计页面
     */

    @RequestMapping("/toCount")
    public String toCount(){
        return "after/countMap";
    }

    /**
     * 消费统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/testCount")
    public List<Map> testCount(){
        List<Map> moneyCount = projectService.getMoneyCount();
        System.out.println(moneyCount);
        return projectService.getMoneyCount();

    }
    /**
     * vip充值统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/vipCount")
    public List<Map> vipCount(){
        List<Map> vipMoneyCount = projectService.getVipMoneyCount();
        System.out.println(vipMoneyCount);
        return projectService.getVipMoneyCount();

    }

    @RequestMapping("/expTestCount")
    public String expTestCount(Model model){
        model.addAttribute("countList", projectService.getMoneyCount());
        return "count/test-count-excel";
    }

}
