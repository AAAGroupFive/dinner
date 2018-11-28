package com.dinner.controller.tableController;


import com.dinner.service.tabService.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * className:TableController
 * describe:
 * author:邢芳彬
 * createTime:2018-11-22 22:12
 */
@Controller
//@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping("/tableList")
    public String tableList(Model model) {
        return "after/index";
    }
    @RequestMapping("/toMain")
    public String toMain(Model model,Model model1){
        List<Map> list = tableService.getList();
        for (int i = 0; i < list.size(); i++) {
            model.addAttribute("type"+i,list.get(i).get("TAB_STATE"));

        }
        /*for (int i = 0; i < list.size(); i++) {
            model1.addAttribute("number"+i,list.get(i).get("TAB_ID"));

        }
        System.out.println(model1);
        System.out.println(model);*/
        return "after/welcome";
    }
}
