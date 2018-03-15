package com.flyingrain.translate.plan.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 每日任务
 * Created by wally on 5/4/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {

    private int id;

    private int wordNumber;

    private DungeonInfo dungeonInfo;

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

    public DungeonInfo getDungeonInfo() {
        return dungeonInfo;
    }

    public void setDungeonInfo(DungeonInfo dungeonInfo) {
        this.dungeonInfo = dungeonInfo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
