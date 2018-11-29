package com.dinner.controller.countMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dinner.service.projectCountService.ProjectCountService;

/**
 * className:projectCountController
 * discription:
 * author:panjing
 * createTime:2018-11-29 17:03
 */
@Controller
@RequestMapping("/projectCount")
public class projectCountController {
    @Autowired
    private ProjectCountService projectService;

    @ResponseBody
    @RequestMapping("/toCount")
    public Object toCount(){
        return "after/countMap";
    }

    /**
     * 统计
     * @return
     */
    @ResponseBody
    @RequestMapping("/testCount")
    public Object testCount(){
        System.out.println(projectService.getMoneyCount());
        return projectService.getMoneyCount();
    }

    @RequestMapping("/expTestCount")
    public String expTestCount(Model model){
        model.addAttribute("countList", projectService.getMoneyCount());
        return "count/test-count-excel";
    }

}
