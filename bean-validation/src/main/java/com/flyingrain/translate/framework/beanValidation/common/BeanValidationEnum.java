package com.flyingrain.translate.framework.beanValidation.common;

/**
 * Created by wally on 9/5/17.
 */
public enum BeanValidationEnum {
    INVALID("V0001","参数校验错误"),
    VALIDEXCEPTION("V0002","参数校验异常"),
    ;
    private String code;

    private String msg;

    BeanValidationEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
