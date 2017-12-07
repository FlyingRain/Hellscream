package com.flyingrain.translate.dungeon.api.domain;

/**
 * 用户在副本中的计划
 * Created by wally on 12/6/17.
 */
public enum UserDungeonStatus {
    PREPAREUNPAY(10,"准备开始副本,尚未收费"),
    PREPAREPAID(15,"准备开始副本,已付清"),
    DOING(20,"副本进行中"),
    FINISHED(30,"副本已完成"),
    FAILED(40,"副本失败"),
    ;


    private int status;

    private String desc;


    UserDungeonStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
