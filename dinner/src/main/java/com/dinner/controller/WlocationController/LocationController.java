package com.dinner.controller.WlocationController;

import com.dinner.service.registerService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
    private RegisterService registerService;
    @RequestMapping("/aaa")
    public void setRegisterMessage(){
        System.out.println(" 请求了方法 ");
        int i = registerService.registerUserLoginMessage();
        System.out.println(i+"------------");
    }
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/bbba")
    public String chengelocation1(){
        return "before/Bindex";
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
