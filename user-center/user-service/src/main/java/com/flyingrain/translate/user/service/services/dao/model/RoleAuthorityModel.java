package com.flyingrain.translate.user.service.services.dao.model;

import java.util.Date;

/**
 * 角色权限管理
 * Created by wally on 7/6/17.
 */
public class RoleAuthorityModel {

    private int id;

    private int role_id;

    private int authority_id;

    /**
     * 是否生效0，否1，是
     */
    private int effective;

    private Date data_added;

    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(int authority_id) {
        this.authority_id = authority_id;
    }

    public int getEffective() {
        return effective;
    }

    public void setEffective(int effective) {
        this.effective = effective;
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
