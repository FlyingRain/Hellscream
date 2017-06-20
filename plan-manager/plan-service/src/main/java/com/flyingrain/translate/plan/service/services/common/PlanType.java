package com.flyingrain.translate.plan.service.services.common;

/**
 * 计划类型
 * Created by wally on 6/20/17.
 */
public enum PlanType {
    BYNUMBER(1,"按每天固定单词"),
    BYDEADLINE(2,"按结束日期"),
    ;

    private int type;

    private String desc;

    PlanType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
