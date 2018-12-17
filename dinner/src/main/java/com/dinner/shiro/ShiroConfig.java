package com.dinner.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * className:ShiroConfig
 * discriptoin:
 * author:llw
 * createTime:2018-12-11 20:44
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * Shiro内置过滤器，常用过滤器:
         *
         * anon:无需认证(登录)可以访问
         * authc:必须认证可以访问
         * user:如果使用rememberMe功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap =new LinkedHashMap<String, String>();
        filterMap.put("/login/toLogin","anon");
        filterMap.put("/login/login","anon");
        //System.out.println("------------++-----------------");
        filterMap.put("/login/getVerifyCode","anon");
        //授权过滤器
        filterMap.put("/test","perms[user:update,add]");
//        filterMap.put("/sb/user/update","perms[user:update]");
        filterMap.put("/**","authc");
//        filterMap.put("/question/*","authc");
//        filterMap.put("/exam/*","authc");
//        filterMap.put("/exammanage/*","authc");

        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login/toLogin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/after/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联real
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getReal(){
        return new UserRealm();
    }

    /**
     * thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean()
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
