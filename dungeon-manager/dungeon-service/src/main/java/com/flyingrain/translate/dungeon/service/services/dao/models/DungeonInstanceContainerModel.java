package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 * 副本成员
 * Created by wally on 11/8/17.
 */
public class DungeonInstanceContainerModel {

    /**
     * 主键
     */
    private int id;
    /**
     * 副本实例Id
     */
    private int dungeon_instance_id;
    /**
     * 计划Id
     */
    private int plan_id;
    /**
     * 用户Id
     */
    private int user_id;
    /**
     * 状态
     */
    private int status;
    /**
     * 添加时间
     */
    private Date data_added;
    /**
     * 最后修改时间
     */
    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDungeon_instance_id() {
        return dungeon_instance_id;
    }

    public void setDungeon_instance_id(int dungeon_instance_id) {
        this.dungeon_instance_id = dungeon_instance_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "DungeonInstanceContainerModel{" +
                "id=" + id +
                ", dungeon_instance_id=" + dungeon_instance_id +
                ", plan_id=" + plan_id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
