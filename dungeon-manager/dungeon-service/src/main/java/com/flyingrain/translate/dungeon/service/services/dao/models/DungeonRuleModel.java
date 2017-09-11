package com.flyingrain.translate.dungeon.service.services.dao.models;

import java.util.Date;

/**
 * 副本规则
 * Created by wally on 9/11/17.
 */
public class DungeonRuleModel {

    /**
     * 主键
     */
    private int id;
    /**
     * 规则名称
     */
    private String rule;
    /**
     * 规则参数
     */
    private String rule_param;
    /**
     * 规则类型
     */
    private int rule_type;
    /**
     * 是否生效
     */
    private int is_active;
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

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getRule_param() {
        return rule_param;
    }

    public void setRule_param(String rule_param) {
        this.rule_param = rule_param;
    }

    public int getRule_type() {
        return rule_type;
    }

    public void setRule_type(int rule_type) {
        this.rule_type = rule_type;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
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
