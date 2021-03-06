package com.dinner.controller.beforeUserLoginController;

import com.dinner.service.beforeUserLoginService.BeforeUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
     * 登录逻辑
     */
    @RequestMapping("/CodeCheck")
    @ResponseBody
    public int beforeUserLogin(HttpServletRequest request, HttpSession session,@RequestParam Map map) {
        String inputVerifyCode=request.getParameter("invite");
        //session中获取到的验证码值
        String verifyCodeValue=(String) session.getAttribute("verifyCodeValue");
//        System.out.println("输入的 验证码"+inputVerifyCode);
//        System.out.println("session中的的"+verifyCodeValue);
        //数据库中查询到的账号 密码 的返回结果
        String userid = request.getParameter("userid");
        List<Map> i = beforeUserLoginService.checkUser(map);
      //  System.out.println("登陆页面的map内容"+map);
        //如果判断成功 则完成相应的操作
        //将登陆成功的用户名密码放入session 便于页面显示相应内容
        if(verifyCodeValue.equals(inputVerifyCode.toUpperCase())&&i.size()>0&&i!=null){
            session.setAttribute("phone",map.get("username"));
          //  session.setAttribute("password",map.get("passwordinput"));
           // System.out.println("用户输入的验证码和图片生成的验证码相等，登陆成功");
            return 1;
        }else {
            return 0;
        }
    }

    /***
     * 登录状态检查
     * 如果没有登录 则不能提交预订信息，提示登录
     * @param
     * @return
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    public ArrayList beforeUserLoginCheck(HttpSession session){
      //  System.out.println("请求了 这个 方法....");
         Object phone = session.getAttribute("phone");
         Object password = session.getAttribute("password");
       // System.out.println("去去去求求"+phone);
      //  System.out.println("去去去求求"+password);
        ArrayList arrayList =new ArrayList();
        if (phone==null) {
            //没有登陆 就显示 放一个1，进去，，
            arrayList.add(1);
        }
        if (phone!=null){
            arrayList.add(phone);
            arrayList.add(2);
        }
         return arrayList;
    }

    /**
     * 退出登录方法
     * @param session
     * @return
     */
    @RequestMapping("/singout")
    public String sinout(HttpSession session){
        session.removeAttribute("phone");
        return "redirect:/locationTo/index";
    }

}
