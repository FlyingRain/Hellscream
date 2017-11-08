package com.flyingrain.translate.dungeon.api.requests;

/**
 * 上传测试结果
 * Created by wally on 11/8/17.
 */
public class UploadTestRequest {

    /**
     * 每日任务Id
     */
    private int taskId;
    /**
     * 得分
     */
    private int score;
    /**
     * 副本Id
     */
    private int dungeonInstanceId;
    /**
     * 计划Id
     */
    private int planId;
    /**
     * 用户Id
     */
    private int userId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDungeonInstanceId() {
        return dungeonInstanceId;
    }

    public void setDungeonInstanceId(int dungeonInstanceId) {
        this.dungeonInstanceId = dungeonInstanceId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UploadTestRequest{" +
                "taskId=" + taskId +
                ", score=" + score +
                ", dungeonInstanceId=" + dungeonInstanceId +
                ", planId=" + planId +
                ", userId=" + userId +
                '}';
    }
}
