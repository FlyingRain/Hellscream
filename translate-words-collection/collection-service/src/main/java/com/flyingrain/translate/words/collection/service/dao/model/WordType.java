package com.flyingrain.translate.words.collection.service.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/12/17.
 */
public class WordType {
    private int id;
    private String type_name;
    private int type_code;
    private String belong;
    private int user_id;
    private Date data_added;
    private Date last_modified;

    public String getBelong() {
        return belong;
    }

    public WordType setBelong(String belong) {
        this.belong = belong;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public WordType setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getType_code() {
        return type_code;
    }

    public void setType_code(int type_code) {
        this.type_code = type_code;
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
        return "WordType{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", type_code='" + type_code + '\'' +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
