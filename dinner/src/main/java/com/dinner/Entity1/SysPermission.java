package com.dinner.Entity1;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * className:SysPermission
 * discription:权限信息
 * author:sjq
 * createTime:2018-12-08 15:28
 */
public class SysPermission implements Serializable {

    private String permission;//权限字符串

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
