package com.flyingrain.translate.dungeon.api.domain;

import java.io.Serializable;

/**
 * Created by Uni on 2017/9/9.
 */
public class DungeonRole implements Serializable {

    private int id;             //副本动态的id

    private String role;        //副本规则名称

    private String desc;        //副本动态描述

    private int role_type;

    private int is_active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRole_type() {
        return role_type;
    }

    public void setRole_type(int role_type) {
        this.role_type = role_type;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}
