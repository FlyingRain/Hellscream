package com.flyingrain.translate.dungeon.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

/**
 * 副本实例
 * Created by wally on 9/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DungeonInstance {
    /**
     * 副本实例Id
     */
    private int dungeonId;
    /**
     * 副本实例中的任务
     */
    private List<Integer> planIds;

    /**
     * 实例状态
     */
    private int status;

    /**
     * enrollTime
     */
    private Date enrollTime;
    /**
     * 实例开始时间
     */
    private Date startTime;
    /**
     * 实例结束时间
     */
    private Date finishTime;

    /**
     * 副本详情
     */
    private DungeonDomain dungeonDomain;
    /**
     * 实例备注
     */
    private String remark;

    public int getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    @Override
    public String toString() {
        return "DungeonInstance{" +
                "dungeonId=" + dungeonId +
                ", planIds=" + planIds +
                ", status=" + status +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", dungeonDomain=" + dungeonDomain +
                ", remark='" + remark + '\'' +
                '}';
    }

    public List<Integer> getPlanIds() {
        return planIds;
    }

    public void setPlanIds(List<Integer> planIds) {
        this.planIds = planIds;
    }

    public DungeonDomain getDungeonDomain() {
        return dungeonDomain;
    }

    public void setDungeonDomain(DungeonDomain dungeonDomain) {
        this.dungeonDomain = dungeonDomain;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
