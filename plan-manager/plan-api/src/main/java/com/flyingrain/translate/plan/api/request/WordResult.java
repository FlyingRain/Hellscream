package com.flyingrain.translate.plan.api.request;

/**
 * Created by wul on 5/6/17.
 */
public class WordResult {

    private String wordId;

    /**
     * 单词熟练度
     */
    private int proficiency;

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    @Override
    public String toString() {
        return "WordResult{" +
                "wordId='" + wordId + '\'' +
                ", proficiency=" + proficiency +
                '}';
    }
}
