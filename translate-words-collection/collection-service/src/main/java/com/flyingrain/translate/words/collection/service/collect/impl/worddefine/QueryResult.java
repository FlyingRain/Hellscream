package com.flyingrain.translate.words.collection.service.collect.impl.worddefine;

/**
 * Created by wally on 4/10/17.
 */
public class QueryResult {

    private String msg;

    private int status_code;

    private WordDefinition data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public WordDefinition getData() {
        return data;
    }

    public void setData(WordDefinition data) {
        this.data = data;
    }
}
