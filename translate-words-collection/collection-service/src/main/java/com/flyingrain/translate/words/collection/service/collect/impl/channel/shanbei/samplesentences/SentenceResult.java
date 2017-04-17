package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.samplesentences;

import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
public class SentenceResult {
    private String msg;

    private int status_code;

    private List<Sentence> data;

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

    public List<Sentence> getData() {
        return data;
    }

    public void setData(List<Sentence> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SentenceResult{" +
                "msg='" + msg + '\'' +
                ", status_code=" + status_code +
                ", data=" + data +
                '}';
    }
}
