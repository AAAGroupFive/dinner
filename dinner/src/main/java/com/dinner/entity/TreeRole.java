package com.dinner.entity;

import java.util.List;

/**
 * className:TreeRole
 * discriptoin:
 * author:zz
 * createTime:2018-12-10-16:10
 */
public class TreeRole {
    private Integer id;
    private String label;
    private String url;
    private Integer pid;
    private Integer fid;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    private String className;
    private List<TreeRole> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<TreeRole> getChildren() {
        return children;
    }

    public void setChildren(List<TreeRole> children) {
        this.children = children;
    }
}
