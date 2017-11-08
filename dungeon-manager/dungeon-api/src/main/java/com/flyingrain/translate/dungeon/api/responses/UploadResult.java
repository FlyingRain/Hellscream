package com.flyingrain.translate.dungeon.api.responses;

/**
 * 上传结果
 * Created by wally on 11/8/17.
 */
public class UploadResult {

    /**
     * 状态
     */
    private int status;
    /**
     * 剩余次数
     */
    private int leftTimes;
    /**
     * 描述
     */
    private String desc;


    public int getStatus() {
        return status;
    }

    public int getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(int leftTimes) {
        this.leftTimes = leftTimes;
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

    @Override
    public String toString() {
        return "UploadResult{" +
                "status=" + status +
                ", leftTimes=" + leftTimes +
                ", desc='" + desc + '\'' +
                '}';
    }
}
