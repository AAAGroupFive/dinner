package com.dinner.controller.AfterLoginController;

import com.dinner.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * className:LoginController
 * discriptoin:
 * author:王朝军
 * createTime:2018-11-30 16:52
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "after/after-login";
    }
    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam Map map, HttpSession session, Model model, HttpServletRequest request){
        List<Map> adminLogin = loginService.userLogin(map);
        System.out.println(adminLogin);
        if(adminLogin!=null&&adminLogin.size()>0){
            session.setAttribute("userName", map.get("userName"));
            return "redirect:index";
        }else{ //错误
            model.addAttribute("errorInfo", "用户名或者密码错误");
            return "redirect:toLogin";
        }

    }
    @ResponseBody
    @RequestMapping("/getSession")
    public Object getSession(HttpSession session){
        return session.getAttribute("userName");
    }

}
