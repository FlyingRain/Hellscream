package com.flyingrain.translate.framework.lang.common;

import java.io.Serializable;

/**
 * 基础结果类
 * Created by wally on 6/14/17.
 */
public class Result<T> implements Serializable{
    private static final long serialVersionUID = -1575917194054203766L;

    /**
     * 结果
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String msg;

    /**
     * 正真结果
     */
    private T realResult;

    public Result(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(boolean success, String code, String msg, T realResult) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.realResult = realResult;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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
