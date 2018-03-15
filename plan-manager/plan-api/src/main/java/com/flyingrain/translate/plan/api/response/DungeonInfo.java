package com.flyingrain.translate.plan.api.response;

/**
 * 计划所在副本信息
 * Created by wally on 3/15/18.
 */
public class DungeonInfo {

    /**
     * 副本实例Id
     */
    private int dungeonInstanceId;

    /**
     * 状态
     */
    private int status;

    /**
     * 描述
     */
    private String desc;

    public int getDungeonInstanceId() {
        return dungeonInstanceId;
    }

    public void setDungeonInstanceId(int dungeonInstanceId) {
        this.dungeonInstanceId = dungeonInstanceId;
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
