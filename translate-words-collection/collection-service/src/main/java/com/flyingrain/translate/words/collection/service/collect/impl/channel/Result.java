package com.flyingrain.translate.words.collection.service.collect.impl.channel;

/**
 * Created by wally on 4/11/17.
 */
public class Result<T> {

    private String msg;

    private String code;

    private boolean isSuccess;

    private T channelResult;

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

    public T getChannelResult() {
        return channelResult;
    }

    public void setChannelResult(T channelResult) {
        this.channelResult = channelResult;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", isSuccess=" + isSuccess +
                ", channelResult=" + channelResult +
                '}';
    }
}
