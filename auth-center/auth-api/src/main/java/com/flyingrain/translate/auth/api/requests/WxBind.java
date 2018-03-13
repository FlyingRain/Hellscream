package com.flyingrain.translate.auth.api.requests;

/**
 * Created by wally on 3/9/18.
 */
public class WxBind {

    private String wxNo;

    private AuthLoginRequest loginRequest;

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public AuthLoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(AuthLoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
}
