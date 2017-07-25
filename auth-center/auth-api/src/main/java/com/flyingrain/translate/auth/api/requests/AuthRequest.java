package com.flyingrain.translate.auth.api.requests;

/**
 * 鉴权
 * Created by wally on 17-7-25.
 */
public class AuthRequest {

    /**
     * token
     */
    private String token;
    /**
     * 地址
     */
    private String url;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
