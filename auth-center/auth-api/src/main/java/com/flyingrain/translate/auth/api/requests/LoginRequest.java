package com.flyingrain.translate.auth.api.requests;

/**
 * Created by wally on 17-7-20.
 */
public class LoginRequest {

    /**
     * 签名
     */
    private String sign;
    /**
     * 原文
     */
    private String param;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
