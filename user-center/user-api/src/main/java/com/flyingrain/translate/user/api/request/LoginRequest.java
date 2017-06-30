package com.flyingrain.translate.user.api.request;

/**
 * Created by wally on 6/30/17.
 */
public class LoginRequest {

    private String sign;

    private String userName;

    private String password;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
