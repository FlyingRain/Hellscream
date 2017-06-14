package com.flyingrain.translate.plan.api.response;

import java.util.List;

/**
 * 每日任务
 * Created by wally on 5/4/17.
 */
public class Task {

    private int wordNumber;

    private int newWordNumber;

    private List<Word> newWords;

    private List<Word> oldWords;

    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    public int getNewWordNumber() {
        return newWordNumber;
    }

    public void setNewWordNumber(int newWordNumber) {
        this.newWordNumber = newWordNumber;
    }

    public List<Word> getNewWords() {
        return newWords;
    }

    public void setNewWords(List<Word> newWords) {
        this.newWords = newWords;
    }

    public List<Word> getOldWords() {
        return oldWords;
    }

    public void setOldWords(List<Word> oldWords) {
        this.oldWords = oldWords;
    }


    @Override
    public String toString() {
        return "Task{" +
                "wordNumber=" + wordNumber +
                ", newWordNumber=" + newWordNumber +
                ", newWords=" + newWords +
                ", oldWords=" + oldWords +
                '}';
    }
}
