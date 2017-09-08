package com.flyingrain.translate.dungeon.api.responses;

/**
 * Created by wally on 9/8/17.
 */
public class JoinResult {

    private boolean success;

    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
