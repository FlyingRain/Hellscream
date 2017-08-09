package com.flyingrain.translate.user.service.services.common;

/**
 * 用户角色枚举
 * Created by wally on 8/9/17.
 */
public enum RoleEnum {
    COMMON("common","普通用户"),
    ;

    private String role;

    private String desc;

    RoleEnum(String role, String desc) {
        this.role = role;
        this.desc = desc;
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
}
