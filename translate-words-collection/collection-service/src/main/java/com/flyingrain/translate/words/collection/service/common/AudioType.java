package com.flyingrain.translate.words.collection.service.common;

/**
 * Created by wally on 4/13/17.
 */
public enum AudioType {
    UK_AUDIO("uk","英式发音"),US_AUDIO("us","美式发音");

    public String type;
    public String desc;

    AudioType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
