package com.flyingrain.translate.dungeon.service.services.common;

/**
 * Created by wally on 12/5/17.
 */
public enum ExceptionEnum {
    PLANFAIL("D0001","查询计划失败"),

    ;



    private String code;

    private String desc;

    ExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
