package com.flyingrain.translate.dungeon.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 副本限制
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DungeonLimit {

    /**
     * 限制类型
     */
    private String type;
    /**
     * 值
     */
    private String value;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * 优先级
     */
    private int priority;

    /**
     * 描述
     */
    private String desc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
