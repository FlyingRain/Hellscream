package com.flyingrain.translate.framework.lang.common;

/**
 * Created by wally on 6/16/17.
 */
public enum FrameworkExceptionCode {
    SYSERROR("F9999","框架内部错误"),
    ;

    private String code;

    private String msg;

    FrameworkExceptionCode(String code, String msg) {
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
