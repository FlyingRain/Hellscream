package com.flyingrain.translate.dungeon.api.requests;

import com.flyingrain.translate.dungeon.api.domain.DungeonLimit;

import java.util.List;

/**
 * 副本查询条件
 * Created by wally on 9/8/17.
 */
public class DungeonQueryRequest {

    /**
     * 页码
     */
    private int pageNum;
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 副本Id
     */
    private Integer dungeonId;
    /**
     * 副本限制条件
     */
    private List<DungeonLimit> limits;
    /**
     * 状态
     */
    private String status;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getDungeonId() {
        return dungeonId;
    }

    public void setDungeonId(Integer dungeonId) {
        this.dungeonId = dungeonId;
    }

    public List<DungeonLimit> getLimits() {
        return limits;
    }

    public void setLimits(List<DungeonLimit> limits) {
        this.limits = limits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
