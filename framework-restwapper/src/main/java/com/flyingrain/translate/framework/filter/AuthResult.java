package com.flyingrain.translate.framework.filter;

/**
 * Created by wally on 1/10/18.
 */
public class AuthResult {

    private boolean result;

    private int userId;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
