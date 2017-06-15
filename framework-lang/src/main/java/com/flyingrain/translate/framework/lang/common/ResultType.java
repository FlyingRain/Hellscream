package com.flyingrain.translate.framework.lang.common;

/**
 * Created by wally on 6/15/17.
 */
public enum ResultType {
    SUCCESS("00","成功"),
    FAILED("99","失败"),
    NOEFFECT("50","登陆失效");

    private String code;

    private String msg;

    ResultType(String code, String msg) {
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
