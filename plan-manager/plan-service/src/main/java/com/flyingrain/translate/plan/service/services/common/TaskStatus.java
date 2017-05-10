package com.flyingrain.translate.plan.service.services.common;

/**
 * 每日任务状态枚举
 * Created by wally on 5/10/17.
 */
public enum TaskStatus {

    PROCESSING(10,"处理中"),COMPLETE(30,"完成"),CANECEL(60,"取消");

    public int value;

    public String desc;

    TaskStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
