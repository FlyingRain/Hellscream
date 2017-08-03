package com.flyingrain.translate.auth.service.common;

/**
 *
 * Created by wally on 8/3/17.
 */
public enum AuthError {

    PARASEFAIL("A001","解析报文失败"),
    VERIFYSIGNFAIL("A002","验签失败"),
    ;

    private String code;

    private String msg;

    AuthError(String code, String msg) {
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
