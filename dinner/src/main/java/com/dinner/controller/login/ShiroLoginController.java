package com.dinner.controller.login;

import com.dinner.service.emp.EmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * className:LoginController
 * discriptoin:
 * author:dzq
 * createTime:2018-11-23 16:55
 */
@Controller
@RequestMapping("login")
public class ShiroLoginController {
    @Autowired
    private EmpService empService;

    /**
     * 跳转到登陆界面
     *
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        /*if (request.getParameter("error")!=null){
            Integer error = Integer.valueOf(request.getParameter("error"));
            if (error==1){
                model.addAttribute("error","验证码输入错误！");
            }else {
                model.addAttribute("error","用户名或密码错误！");
            }
        }*/
        return "after/login";
    }

    /**
     * 跳转到导航栏主界面
     *
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex() {
        return "login/indexA";
    }

/*******************************************-验证码-******************************************************/
    /**
     * 最初的验证码
     *
     * @return
     */
    @RequestMapping("/showLoginView")
    public ModelAndView getIndex() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:login/tologin");
        return mv;
    }

    /**
     * 获取验证码
     *
     * @param response
     * @param session
     */
    @RequestMapping("/getVerifyCode")
    public void generate(HttpServletResponse response, HttpSession session) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String verifyCodeValue = drawImg(output);
        session.setAttribute("verifyCodeValue", verifyCodeValue);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘画验证码
     *
     * @param output
     * @return
     */
    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,
            BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 随机参数一个字符
     *
     * @return
     */
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam Map map, Model model) {
        //String inputVerifyCode=request.getParameter("verifyCode");
        System.out.println(map.get("userName"));
        System.out.println(map.get("passWord"));
        //使用shiro编写认证
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken((String) map.get("userName"), (String) map.get("passWord"));
        //执行登录方法
        try {
            subject.login(token);
                List<Map> userList = empService.login(map);
                System.out.println(userList.size());
                if (userList != null && userList.size() > 0) {
                    session.setAttribute("userName", map.get("userName"));
                    session.setAttribute("passWord", map.get("passWord"));
                    session.setMaxInactiveInterval(600000);
                    System.out.println("aaaaaaaaaaaaaaa");
                    return "redirect:../power/index";
                } else {
                    model.addAttribute("error", "用户名或密码错误!");
                    System.out.println("bbbbbbbbbbbbbbbb");
                    return "after/login";
                }

            // return "redirect:/login/indexA";
            //return "after/index";
        } catch (UnknownAccountException e) {
//                  e.printStackTrace();
            System.out.println("cccccccccccccc");
            model.addAttribute("msg", "用户名不存在");
            return "after/login";
        } catch (IncorrectCredentialsException e) {
//                  e.printStackTrace();
            System.out.println("dddddddddddddddddddd");
            model.addAttribute("msg", "密码错误");
            return "after/login";
        }

    }
}