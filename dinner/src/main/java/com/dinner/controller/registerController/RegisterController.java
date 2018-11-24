package com.dinner.controller.registerController;

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
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("/aaa")
    public void setRegisterMessage(){
        System.out.println(" 请求了方法 ");
        int i = registerService.registerUserLoginMessage();
        System.out.println(i+"------------");
    }

    @RequestMapping("/bbba")
    public String chengelocation1(){
        return "before/Bindex";
    }
    @RequestMapping("/bbbb")
    public String chengelocation2(){
        return "before/contact_us";
    }

    @RequestMapping("/bbbc")
    public String chengelocation3(){
        return "before/reserve";
    }
    @RequestMapping("/bbbd")
    public String chengelocation4(){
        return "before/services";
    }
}
