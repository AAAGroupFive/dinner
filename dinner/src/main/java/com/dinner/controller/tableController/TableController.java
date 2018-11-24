package com.dinner.controller.tableController;


import com.dinner.service.tabService.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
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

    //主页面
    @RequestMapping("/tableList")
    public String tableList(Model model) {
        return "after/index";
    }

    //iframe页面、桌子列表
    @RequestMapping("/toMain")
    public String toMain(Model model){
        List<Map> list = tableService.getList();
        for (int i=0;i<list.size();i++) {
            model.addAttribute("type" + i, list.get(i).get("TAB_TYPE"));
        }
        for (int i=0;i<list.size();i++) {
            model.addAttribute("id" + i, list.get(i).get("TAB_ID"));
        }
        return "after/welcome";
    }
}
