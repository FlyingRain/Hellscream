package com.flyingrain.translate.dungeon.service.services.limitchains.limits.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by wally on 10/31/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberLimitModel {

    private int largest;

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
        return "NumberLimitModel{" +
                "largest=" + largest +
                ", least=" + least +
                '}';
    }
}
