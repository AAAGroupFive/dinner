package com.dinner.controller.beforeUserLoginController;

import com.dinner.service.beforeUserLoginService.BeforeUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * className:BeforeUserLoginController
 * discriptoin:会员登录控制层
 * author:wxz
 * createTime:2018-11-24 14:15
 */
@Controller
@RequestMapping("/beforeUserLogin")
public class BeforeUserLoginController {
    //spring 实例化对象
    @Autowired
    private BeforeUserLoginService beforeUserLoginService;
    /**
     * 登录逻辑 验证码校验
     */
    @RequestMapping("/CodeCheck")
    public String beforeUserLogin(HttpServletRequest request, HttpSession session,@RequestParam Map map) {
        System.out.println("客户端发出了请求");
        //用户输入的 验证码值
        String inputVerifyCode=request.getParameter("verifyCode");

        System.out.println("客户端输入的验证码值------>" + inputVerifyCode);
        //session中获取到的验证码值
        String verifyCodeValue=(String) session.getAttribute("verifyCodeValue");
        System.out.println("Session中的验证码值------>"+ verifyCodeValue);
        //数据库中查询到的账号 密码 的返回结果
        String userid = request.getParameter("userid");
        System.out.println("客户端输入的用户名------>"+userid);
        int i = beforeUserLoginService.checkUser(map);
        //如果判断成功 则完成相应的操作
        if(verifyCodeValue.equals(inputVerifyCode.toUpperCase())){
            System.out.println("用户输入的验证码和图片生成的验证码相等，登陆成功");
            return "redirect:/locationTo/bbbf";
        }else {
            return "locationTo/bbbe";
        }
    }

    /***
     * 登录状态检查
     * 如果没有登录 则不能提交预订信息，提示登录
     * @param session
     * @return
     */
    @RequestMapping("/loginCheck")
    public int beforeUserLoginCheck(HttpSession session){
        Object username = session.getAttribute("username");
        Object password = session.getAttribute("password");

        System.out.println(username);
        System.out.println(password);

        return 1;

    }

}
