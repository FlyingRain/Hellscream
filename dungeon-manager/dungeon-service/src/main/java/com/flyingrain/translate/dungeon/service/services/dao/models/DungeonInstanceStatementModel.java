package com.flyingrain.translate.dungeon.service.services.dao.models;

/**
 * 副本实例流水表
 * Created by wally on 11/8/17.
 */
public class DungeonInstanceStatementModel {

    private int id;

    private int dungeon_instance_id;

    private int task_id;

    private int score;

    private int plan_id;

    private int user_id;

    private int status;

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

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "DungeonInstanceStatementModel{" +
                "id=" + id +
                ", dungeon_instance_id=" + dungeon_instance_id +
                ", task_id=" + task_id +
                ", score=" + score +
                ", plan_id=" + plan_id +
                ", user_id=" + user_id +
                ", status=" + status +
                '}';
    }
}
