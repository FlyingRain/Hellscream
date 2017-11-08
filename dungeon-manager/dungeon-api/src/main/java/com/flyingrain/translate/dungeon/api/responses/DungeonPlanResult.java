package com.flyingrain.translate.dungeon.api.responses;

/**
 * 计划在副本中的状态
 * Created by wally on 11/8/17.
 */
public class DungeonPlanResult {

    /**
     * 副本实例Id
     */
    private int dungeonInstanceId;
    /**
     * 计划在副本中的状态
     */
    private int status;
    /**
     * 计划Id
     */
    private int planId;

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

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "DungeonPlanResult{" +
                "dungeonInstanceId=" + dungeonInstanceId +
                ", status=" + status +
                ", planId=" + planId +
                '}';
    }
}
