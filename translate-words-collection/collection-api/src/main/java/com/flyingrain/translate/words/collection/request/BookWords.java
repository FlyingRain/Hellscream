package com.flyingrain.translate.words.collection.request;

import java.util.List;

/**
 * Created by wally on 6/10/17.
 */
public class BookWords {
    /**
     * 单词Id（除外）
     */
    private List<Integer> wordIds;

    /**
     * 书本类型
     */
    private int bookType;

    /**
     * 取出的个数
     */
    private int number;

    public List<Integer> getWordIds() {
        return wordIds;
    }

    public void setWordIds(List<Integer> wordIds) {
        this.wordIds = wordIds;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BookWords{" +
                "wordIds=" + wordIds +
                ", bookType=" + bookType +
                ", number=" + number +
                '}';
    }
}
