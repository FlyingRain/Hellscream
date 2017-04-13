package com.flyingrain.translate.words.collection.service.common;

/**
 * Created by wally on 4/13/17.
 */
public enum ErrorType {

    STRUCTURE_ERROR(10,"结构错误"),CHANNEL_ERROR(20,"渠道返回错误"),NULL_ERROR(30,"渠道返回空");

    public int code;
    public String msg;

    ErrorType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
