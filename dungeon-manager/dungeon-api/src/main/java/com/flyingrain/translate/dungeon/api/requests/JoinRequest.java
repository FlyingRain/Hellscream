package com.flyingrain.translate.dungeon.api.requests;

/**
 * 加入副本请求
 * Created by wally on 10/26/17.
 */
public class JoinRequest {
    /**
     * 用户Id
     */
    private int userId;
    /**
     * 计划Id
     */
    private int planId;
    /**
     * 副本实例Id
     */
    private int dungeonInstanceId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getDungeonInstanceId() {
        return dungeonInstanceId;
    }

    public void setDungeonInstanceId(int dungeonInstanceId) {
        this.dungeonInstanceId = dungeonInstanceId;
    }
}
