package com.flyingrain.translate.user.service.services.dao.model;

import java.util.Date;

/**
 * 权限
 * Created by wally on 17-7-13.
 */
public class AuthorityModel {

    /**
     * 主键
     */
    private int id;
    /**
     * 权限名称
     */
    private String authority_name;
    /**
     * 权限地址
     */
    private String url;
    /**
     * 权限描述
     */
    private String desc;

    private Date data_added;

    private Date last_modified;

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getAuthority_name() {
        return authority_name;
    }

    public void setAuthority_name(String authority_name) {
        this.authority_name = authority_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }
}
