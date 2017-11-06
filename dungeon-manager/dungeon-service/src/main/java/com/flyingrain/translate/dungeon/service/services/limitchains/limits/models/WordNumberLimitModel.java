package com.flyingrain.translate.dungeon.service.services.limitchains.limits.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by wally on 10/31/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordNumberLimitModel {

    /**
     * 最大单词数
     */
    private int largest;
    /**
     * 最小单词数
     */
    private int least;

    public int getLargest() {
        return largest;
    }

    public void setLargest(int largest) {
        this.largest = largest;
    }

    public int getLeast() {
        return least;
    }

    public void setLeast(int least) {
        this.least = least;
    }

    @Override
    public String toString() {
        return "WordNumberLimitModel{" +
                "largest=" + largest +
                ", least=" + least +
                '}';
    }
}
