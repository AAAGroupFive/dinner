package com.dinner.Entity1;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * className:SysRole
 * discription:角色信息
 * author:sjq
 * createTime:2018-12-08 15:27
 */
public class SysRole implements Serializable {

    private String roleId;
    private String role;//role_name

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public SysRole() {
    }

    public SysRole(String roleId, String role) {
        this.roleId = roleId;
        this.role = role;

    }
}
