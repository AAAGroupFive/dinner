package com.dinner.controller.registerController;

import com.dinner.service.registerService.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Session;
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
	@ResponseBody
    public int RegisterMessage(@RequestParam  Map map,HttpSession session){
	//	System.out.println("。。。。请求了这个方法");
		//检查用户是否存在
    	List<Map> maps = registerService.checkUser(map);
		Object letterCode = map.get("letterCode");
		Object code = session.getAttribute("code");
	//	System.out.println(letterCode);
	//	System.out.println(code);
	//	System.out.println("maps 里内容是。。。"+maps);
		if (maps!=null&&maps.size()>0){
			System.out.println("标记1");
			//用户已经存在
			return 1;
		}if (!letterCode.equals(code)){
			System.out.println("标记2");
			return 2;
		}
		else {
			registerService.registerUserLoginMessage(map);
			//return 		"redirect:/locationTo/bbbf";
			return 0;
		}

    }
    @RequestMapping("/registerCheck")
    public String registerCheck(@RequestParam  Map map,HttpSession session){
		System.out.println("请求了重复检查方法");
        return " ";
    }
}
