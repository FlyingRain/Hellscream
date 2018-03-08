package com.flyingrain.translate.user.api.request;

/**
 * Created by wally on 3/8/18.
 */
public class WxBindRequest {

    private String wxNo;

    private LoginRequest loginRequest;

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }
}
