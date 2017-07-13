package com.flyingrain.translate.user.service.services.common;

/**
 * Created by wally on 7/10/17.
 */
public enum UserCenterExceptionEnum {

    ParamError("U0001","参数错误"),
    InsertFailure("U0002","插入用户失败"),
    LoginFailure("U0003","登陆失败，用户名或密码错误"),
    ;

    private String code;

    private String msg;


    UserCenterExceptionEnum(String code, String msg) {
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
