package com.dinner.controller.beforeUserLoginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * className:BeforeUserLoginController
 * discriptoin:会员登录控制层
 * author:wxz
 * createTime:2018-11-24 14:15
 */
@Controller
@RequestMapping("/beforeUserLogin")
public class BeforeUserLoginController {
    /**
     * 登录逻辑
     */
    @RequestMapping("/CodeCheck")
    public String beforeUserLogin(HttpServletRequest request, HttpSession session) {
        String inputVerifyCode=request.getParameter("verifyCode");
        System.out.println("用户输入的验证码值------>"
                + inputVerifyCode);
        String verifyCodeValue=(String) session.getAttribute("verifyCodeValue");
        System.out.println("Session中的验证码值------>"
                + verifyCodeValue);
        if(verifyCodeValue.equals(inputVerifyCode.toUpperCase())){
            System.out.println("用户输入的验证码和图片生成的验证码相等，登陆成功");
            return "redirect:/locationTo/bbba";
        }else {
            return "locationTo/bbbe";
        }

    }
}
