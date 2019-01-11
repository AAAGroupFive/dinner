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
     *跳转到图表统计页面
     */

    @RequestMapping("/toCount")
    public String toCount(){
        return "after/countMap";
    }

    /**
     * 统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/testCount")
    public List<Map> testCount(){
        System.out.println("11111111111");

        List<Map> moneyCount = projectService.getMoneyCount();
        System.out.println(moneyCount);
        return projectService.getMoneyCount();

    }

    @RequestMapping("/expTestCount")
    public String expTestCount(Model model){
        model.addAttribute("countList", projectService.getMoneyCount());
        return "count/test-count-excel";
    }

}
