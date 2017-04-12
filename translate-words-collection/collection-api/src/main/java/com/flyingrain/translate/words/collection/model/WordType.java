package com.flyingrain.translate.words.collection.model;

/**
 * Created by wally on 4/11/17.
 */
public enum WordType {

    BASIC(1,"基础词汇"),
    TOEFL_BASIC(50,"托福基本词汇"),
    TOEFL_MIDDLE(51,"托福中级词汇"),
    TOEFL_HIGH(52,"托福高级词汇");

    public int type;

    public String description;

    WordType(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public static boolean isExist(int code){
        WordType wordTypes[] = WordType.values();
        for (WordType w : wordTypes) {
            if (w.type == code) {
                return true;
            }
        }
        return false;
    }
}
