package com.dinner.Entity1;

import java.io.Serializable;

/**
 * className:User
 * discription:
 * author:sjq
 * createTime:2018-12-10 09:20
 */
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String passWord;
    private String remark;
    private Long telephone;
    private String signdate;
    private SysRole role;

    public User(){}
    

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getSigndate() {
        return signdate;
    }

    public void setSigndate(String signdate) {
        this.signdate = signdate;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public User(Integer userId, String userName, String passWord, String remark,Long telephone, SysRole role,String signdate) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.remark = remark;
        this.role = role;
        this.telephone=telephone;
        this.signdate=signdate;
    }
}
