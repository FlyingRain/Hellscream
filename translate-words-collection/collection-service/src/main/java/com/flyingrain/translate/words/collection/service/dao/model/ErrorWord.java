package com.flyingrain.translate.words.collection.service.dao.model;

/**
 * Created by wally on 4/13/17.
 */
public class ErrorWord {
    private String word;
    private int type;
    private String error_msg;
    private int error_code;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "ErrorWord{" +
                "word='" + word + '\'' +
                ", type='" + type + '\'' +
                ", error_msg='" + error_msg + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
