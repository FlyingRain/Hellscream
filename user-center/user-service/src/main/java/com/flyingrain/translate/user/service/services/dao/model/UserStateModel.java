package com.flyingrain.translate.user.service.services.dao.model;

import java.util.Date;

/**
 * 用户状态
 * Created by wally on 17-7-5.
 */
public class UserStateModel {

    /**
     * id
     */
    private int id;
    /**
     * 用户Id
     */
    private int user_id;
    /**
     * 状态
     */
    private int status;
    /**
     * 冻结状态
     */
    private int is_frezze;
    /**
     * 用户等级
     */
    private int level;
    /**
     * 添加日期
     */
    private Date data_added;
    /**
     * 最后添加日期
     */
    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIs_frezze() {
        return is_frezze;
    }

    public void setIs_frezze(int is_frezze) {
        this.is_frezze = is_frezze;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
