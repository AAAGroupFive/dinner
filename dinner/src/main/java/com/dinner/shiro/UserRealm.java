package com.dinner.shiro;

import com.dinner.entity.Emp;
import com.dinner.service.emp.EmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserRealm
 * discriptoin:过滤配置
 * author:llw
 * createTime:2018-12-11 20:45
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //到数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        //System.out.println("===================================");
        Subject subject = SecurityUtils.getSubject();
        Map user= (Map) subject.getPrincipal();
        //System.out.println(user);
//        int empId = Integer.valueOf(user.get("empId")+"");
        int empId =Integer.valueOf(user.get("EMPID")+"");
        //System.out.println("--------------"+empId);
        List<Map> dbUser =  empService.findByid(empId);
        //System.out.println(dbUser+"--------------"+dbUser.get(0).get("EMP_POWER"));
        //dbUser.getPerms();
        // info.addRole("userA");
        info.addStringPermission(dbUser.get(0).get("EMP_POWER")+"");
        return info;
    }

    @Autowired
    private EmpService empService;
    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //System.out.println("执行认证逻辑");

        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //System.out.println(token.getUsername());
        String value1=token.getUsername();
        //System.out.println("---------"+value1);
        Map map = new HashMap();
        map.put("userName",value1);
        //System.out.println("++++++++++++"+map.get("userName"));
        List<Map> user= empService.getRole(map);
        //System.out.println(user);
        if(user==null&&user.size()<1){
            //用户名不存在
            return null;
        }
        //System.out.println(user.get(0).get("EMPID")+"--------------");
        return new SimpleAuthenticationInfo(user,user.get(0).get("PASSWORD"),"");
    }
}
