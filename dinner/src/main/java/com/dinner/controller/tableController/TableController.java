package com.dinner.controller.tableController;


import com.dinner.service.reserve.ReserveService;
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

    @Autowired
    private ReserveService reserveService;

    @RequestMapping("/tableList")
    public String tableList() {
        return "after/index";
    }

    @RequestMapping("/toMain")
    public String toMain(Model model,String  selectDate){
        /*查桌子表*/
        List<Map> list = tableService.getList();
        /*查预订表*/
        List<Map> list1 = reserveService.reserveList(selectDate);

       /* for (int i = 0; i < list.size(); i++) {
            Object a = list.get(i).get("TAB_STATE");
            if (list1.size()>0) {
                if (list.get(i).get("TAB_ID").equals(list1.get(0).get("RE_NUMBER")) ) {
                    a = 2;
                }
            }
            model.addAttribute("type"+i,a);

        }*/
        for (Map tmap : list) {
            Object a = tmap.get("TAB_STATE");
            if (list1.size()>0) {
                boolean isHave =true;
                for (Map map : list1) {
                    if (tmap.get("TAB_ID").equals(map.get("RE_NUMBER")) ) {
                        tmap.put("TAB_STATE", map.get("STATE"));
                        isHave=false;
                    }
                }
                if(false){
                    tmap.put("TAB_STATE", 0);
                }
            }
          //  model.addAttribute("type"+i,a);
        }
        model.addAttribute("selectDate", selectDate);
        model.addAttribute("tbList", list);
        return "after/welcome";
    }
}
