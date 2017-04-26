package com.flyingrain.translate.plan.api.response;

/**
 * Created by wally on 4/25/17.
 */
public class Result<T> {

    private String code;

    private String msg;

    private T realResult;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRealResult() {
        return realResult;
    }

    public void setRealResult(T realResult) {
        this.realResult = realResult;
    }
}
