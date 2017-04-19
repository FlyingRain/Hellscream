package com.flyingrain.translate.words.collection.model;

/**
 * Created by wally on 4/19/17.
 */
public enum ResultType {

   SUCCESS("00","成功"),FAIL("99","失败");
    public String code;

    public String desc;

    ResultType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
