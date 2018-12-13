package com.dinner.controller.registerController;

import com.dinner.service.registerService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    @RequestMapping("/userRegister")
    public String RegisterMessage(@RequestParam  Map map){
        System.out.println("客户端 请求了此方法 ");
        int i = registerService.registerUserLoginMessage(map);
        System.out.println(map);
        System.out.println(i+"------------");
        return "redirect:/locationTo/bbbf";
    }

}
