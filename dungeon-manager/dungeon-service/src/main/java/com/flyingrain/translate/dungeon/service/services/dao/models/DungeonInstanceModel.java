package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 * 副本实例模型
 * Created by wally on 9/11/17.
 */
public class DungeonInstanceModel {

    /**
     * 主键
     */
    private int id;
    /**
     * 副本模板Id
     */
    private int dungeon_source;
    /**
     * 数量
     */
    private int numbers;

    /**
     * 开始时间
     */
    private Date start_time;
    /**
     *
     */
    private Date enroll_time;
    /**
     * 结束时间
     */
    private Date end_time;
    /**
     * 实例状态
     */
    private int dungeon_status;

    private Date data_added;

    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getDungeon_source() {
        return dungeon_source;
    }

    public void setDungeon_source(int dungeon_source) {
        this.dungeon_source = dungeon_source;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Date getEnroll_time() {
        return enroll_time;
    }

    public void setEnroll_time(Date enroll_time) {
        this.enroll_time = enroll_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public int getDungeon_status() {
        return dungeon_status;
    }

    public void setDungeon_status(int dungeon_status) {
        this.dungeon_status = dungeon_status;
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
}
