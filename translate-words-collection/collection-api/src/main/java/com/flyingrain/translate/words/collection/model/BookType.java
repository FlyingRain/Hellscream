package com.flyingrain.translate.words.collection.model;

/**
 * Created by wally on 4/11/17.
 */
public enum BookType {

    BASIC(1,"基础词汇"),
    TOEFL_BASIC(50,"托福基本词汇"),
    TOEFL_MIDDLE(51,"托福中级词汇"),
    TOEFL_HIGH(52,"托福高级词汇"),
    CET_FOUR(40,"大学英语四级"),
    CET_SIX(60,"大学英语六级"),
    PET_FOUR(45,"专业英语四级"),
    PET_SIX(65,"专业英语六级"),
    PET_EIGHTH(85,"专业英语八级");

    public int type;

    public String description;

    BookType(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public static boolean isExist(int code){
        BookType bookTypes[] = BookType.values();
        for (BookType w : bookTypes) {
            if (w.type == code) {
                return true;
            }
        }
        return false;
    }
}
