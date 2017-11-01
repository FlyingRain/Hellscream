package com.flyingrain.translate.dungeon.service.services.common;

/**
 * Created by wally on 11/1/17.
 */
public enum LimitEnum {
    WORDTYPE("wordType","单词书限制"),
    WORDNUMBER("wordNumber","单词数量限制"),
    TIME("time","时间约束"),
    MEMBERNUM("memberNum","成员数量限制"),
    ;


    LimitEnum(String limitName, String desc) {
        this.limitName = limitName;
        this.desc = desc;
    }

    private String limitName;

    private String desc;

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
