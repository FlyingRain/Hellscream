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
     * 副本Id
     */
    private int dungeonId;
    /**
     * 副本实例中的用户
     */
    private List<Integer> userIds;
    /**
     * 实例开始时间
     */
    private Date startTime;
    /**
     * 实例结束时间
     */
    private Date finishTime;

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

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
