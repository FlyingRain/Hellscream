package com.flyingrain.translate.dungeon.api.responses;

/**
 * Created by wally on 9/8/17.
 */
public class JoinResult {

    /**
     * 结果
     */
    private boolean success;
    /**
     * 副本实例Id
     */
    private int dungeonInstanceId;

    /**
     * 信息
     */
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getDungeonInstanceId() {
        return dungeonInstanceId;
    }

    public void setDungeonInstanceId(int dungeonInstanceId) {
        this.dungeonInstanceId = dungeonInstanceId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JoinResult{" +
                "success=" + success +
                ", dungeonInstanceId=" + dungeonInstanceId +
                ", msg='" + msg + '\'' +
                '}';
    }
}
