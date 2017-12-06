package com.flyingrain.translate.dungeon.service.services.common;

/**
 * Created by wally on 11/1/17.
 */
public enum LimitEnum {
    WORDTYPE(1,"单词书限制"),
    WORDNUMBER(2,"单词数量限制"),
    TIME(3,"时间约束"),
    MEMBERNUM(4,"成员数量限制"),
    PLANTYPE(5,"计划类型限制"),
    ;


    LimitEnum(int limitName, String desc) {
        this.limitName = limitName;
        this.desc = desc;
    }

    private int limitName;

    private String desc;

    public int getLimitName() {
        return limitName;
    }

    public void setLimitName(int limitName) {
        this.limitName = limitName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
