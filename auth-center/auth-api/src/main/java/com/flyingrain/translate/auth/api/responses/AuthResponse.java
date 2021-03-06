package com.flyingrain.translate.auth.api.responses;

/**
 * 鉴权结果
 * Created by wally on 17-7-25.
 */
public class AuthResponse {

    /**
     * 是否有权力访问
     */
    private boolean result;

    /**
     * 用户Id
     */
    private Integer userId;

    public AuthResponse(boolean result, Integer userId) {
        this.result = result;
        this.userId = userId;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
