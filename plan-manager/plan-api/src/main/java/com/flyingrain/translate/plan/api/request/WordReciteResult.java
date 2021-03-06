package com.flyingrain.translate.plan.api.request;

/**
 * Created by wul on 5/6/17.
 */
public class WordReciteResult {

    private int wordId;

    /**
     * 单词熟练度
     */
    private int proficiency;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
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
