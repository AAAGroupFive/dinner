package com.dinner.controller.registerController;

import com.dinner.service.registerService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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
    public  void  setRegisterMessage(Map map){
        registerService.registerUserLoginMessage(map);

    }
}
