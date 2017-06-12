package com.flyingrain.translate.plan.service.services.common;

/**
 * 单词熟练度定义
 * Created by wally on 6/12/17.
 */
public enum WordProficiency {
    STRANGE(0, "陌生"),
    FAMILIAR(10,"熟悉"),
    MASTER(50,"掌握");


    private int proficiency;

    private String desc;

    WordProficiency(int proficiency, String desc) {
        this.proficiency = proficiency;
        this.desc = desc;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
