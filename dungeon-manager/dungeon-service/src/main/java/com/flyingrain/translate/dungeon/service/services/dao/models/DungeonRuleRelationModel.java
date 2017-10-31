package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 * 副本规则映射
 * Created by wally on 9/11/17.
 */
public class DungeonRuleRelationModel {

    /**
     * 副本Id
     */
    private int dungeon_id;
    /**
     * 是否激活
     */
    private int is_active;

    /**
     * 优先级
     */
    private int priority;
    /**
     * 规则Id
     *
     */
    private int rule_id;
    /**
     * 添加时间
     */
    private Date data_added;
    /**
     * 最后修改时间
     */
    private Date last_modified;

    public int getDungeon_id() {
        return dungeon_id;
    }

    public void setDungeon_id(int dungeon_id) {
        this.dungeon_id = dungeon_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRule_id() {
        return rule_id;
    }

    public void setRule_id(int rule_id) {
        this.rule_id = rule_id;
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
