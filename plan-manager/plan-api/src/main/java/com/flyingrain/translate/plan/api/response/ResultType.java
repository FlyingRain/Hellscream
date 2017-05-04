package com.flyingrain.translate.plan.api.response;

/**
 * Created by wally on 4/19/17.
 */
public enum ResultType {

   SUCCESS("00","成功"),FAIL("99","失败"),FAIL_PARAM_INVALID("91","参数错误");
    public String code;

    public String desc;

    ResultType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
