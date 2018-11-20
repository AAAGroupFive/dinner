package com.xfb.controller;

import com.xfb.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * className:UserController
 * describe:
 * author:邢芳彬
 * createTime:2018-11-14 10:43
 */
@Controller
public class UserController {


    @RequestMapping(value = "/subLogin", method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //kykiuy
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }
        return "登录成功";
//        System.out.println("jdskjfkg");
        //邢芳彬加的测试
        //邢芳彬加的测试2222222333444
        //王玺宗修改的 (王玺宗 第二次修改)（王玺宗又修改了一次）（第三次）（第四次）
        //郭大仙的测试
        //ppppsss
        //王朝军修改的
        ///drgfd
    }

}
