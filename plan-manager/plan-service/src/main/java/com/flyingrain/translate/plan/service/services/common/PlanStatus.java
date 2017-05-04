package com.flyingrain.translate.plan.service.services.common;

/**
 * Created by wally on 4/26/17.
 */
public enum PlanStatus {
    UNDERWAY(10,"进行中"),FAIL(20,"失败"),SUCCESS(30,"计划完成"),CANCEL(25,"计划取消");

    public int status;

    public String msg;

    PlanStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
