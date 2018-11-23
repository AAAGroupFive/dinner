package com.dinner.entity;

/**
 * className:User
 * discriptoin:
 * author:wxz
 * createTime:2018-11-22 15:08
 */
public class User {
    private  String identity; //身份
    private  String loginName;//登录名
    private  String passWord;//密码
    private  String phoneNumber;//电话

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
