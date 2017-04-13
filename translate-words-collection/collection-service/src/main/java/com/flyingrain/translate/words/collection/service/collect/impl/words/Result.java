package com.flyingrain.translate.words.collection.service.collect.impl.words;

/**
 * Created by wally on 4/11/17.
 */
public class Result<T> {

    private String msg;

    private String code;

    private boolean isSuccess = false;

    private T queryResult;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(T queryResult) {
        this.queryResult = queryResult;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", isSuccess=" + isSuccess +
                ", queryResult=" + queryResult +
                '}';
    }
}
