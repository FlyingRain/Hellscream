package com.flyingrain.translate.words.collection.service.collect.impl.words;

/**
 * Created by wally on 4/13/17.
 */
public class WrongWord {

    private String word;

    private int type;

    private String wrongMsg;

    private int wrongCode;

    public WrongWord(String word, int type, String wrongMsg, int wrongCode) {
        this.word = word;
        this.type = type;
        this.wrongMsg = wrongMsg;
        this.wrongCode = wrongCode;
    }

    public WrongWord() {
    }

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

    public String getWrongMsg() {
        return wrongMsg;
    }

    public void setWrongMsg(String wrongMsg) {
        this.wrongMsg = wrongMsg;
    }

    public int getWrongCode() {
        return wrongCode;
    }

    public void setWrongCode(int wrongCode) {
        this.wrongCode = wrongCode;
    }

    @Override
    public String toString() {
        return "WrongWord{" +
                "word='" + word + '\'' +
                ", type='" + type + '\'' +
                ", wrongMsg='" + wrongMsg + '\'' +
                ", wrongCode='" + wrongCode + '\'' +
                '}';
    }
}
