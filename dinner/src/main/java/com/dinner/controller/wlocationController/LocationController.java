package com.dinner.controller.wlocationController;

import com.dinner.service.VipService.VipService;
import com.dinner.service.registerService.RegisterService;
import com.dinner.service.food.foodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


/**
 * className:RegisterController
 * discriptoin:
 * author:wxz
 * createTime:2018-11-22 16:41
 */
@Controller
@RequestMapping("/locationTo")
public class LocationController {
    @Autowired
    private VipService vipService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private foodService food;

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index")
    public String chengelocation6(Model model){
        int countVip = vipService.countVip();
        int countFood = food.countFood();
        Map map = new HashMap();
        map.put("countVip", countVip);
        map.put("countFood", countFood);
        model.addAllAttributes(map);
        return "before/Bindex1";
    }
    /**
     * 跳转到联系我们 的页面
     * @return
     */
    @RequestMapping("/bbbb")
    public String chengelocation2(){
        return "before/contact_us";
    }

    /**
     * 跳转到 预定页面
     * @return
     */
    @RequestMapping("/bbbc")
    public String chengelocation3(){
        return "before/reserve";
    }

    /**
     *跳转到 我们的服务 页面
     * @return
     */
    @RequestMapping("/bbbd")
    public String chengelocation4(){
        return "before/services";
    }

    /**
     * 跳转到测试 页面
     * @return
     */
    @RequestMapping("/bbbe")
    public String chengelocation5(){
        return "before/wTest";
    }

}
