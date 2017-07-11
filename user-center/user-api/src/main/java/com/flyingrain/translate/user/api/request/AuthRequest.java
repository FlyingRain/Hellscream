package com.flyingrain.translate.user.api.request;

/**
 * 鉴权请求
 * Created by wally on 17-7-10.
 */
public class AuthRequest {

    /**
     * 用户Id
     */
    private int userId;

    /**
     * 资源地址
     */
    private String url;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "userId=" + userId +
                ", url='" + url + '\'' +
                '}';
    }
}
