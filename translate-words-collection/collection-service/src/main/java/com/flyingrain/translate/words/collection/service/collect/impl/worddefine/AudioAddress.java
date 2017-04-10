package com.flyingrain.translate.words.collection.service.collect.impl.worddefine;

import java.util.List;

/**
 * Created by wally on 4/10/17.
 */
public class AudioAddress {
    /**
     * 英式发音
     */
    private List<String> uk;
    /**
     * 美式发音
     */
    private List<String> us;


    public List<String> getUk() {
        return uk;
    }

    public void setUk(List<String> uk) {
        this.uk = uk;
    }

    public List<String> getUs() {
        return us;
    }

    public void setUs(List<String> us) {
        this.us = us;
    }
}
