package com.flyingrain.translate.auth.api.responses;

/**
 * Created by wally on 17-7-20.
 */
public class LoginResponse {

    /**
     * 用户Id
     */
    private String userId;
    /**
     * 登陆凭证
     */
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
