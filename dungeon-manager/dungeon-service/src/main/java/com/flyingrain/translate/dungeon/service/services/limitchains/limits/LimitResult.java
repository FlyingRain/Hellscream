package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

/**
 * 判断结果
 * Created by wally on 10/30/17.
 */
public class LimitResult {

    private boolean success;

    private String  reason;

    /**
     * 返回成功
     * @return
     */
    public static LimitResult success(){
        LimitResult result = new LimitResult();
        result.success = true;
        return result;
    }

    public static LimitResult fail(String reason){
        LimitResult result = new LimitResult();
        result.success = false;
        result.reason =reason;
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
