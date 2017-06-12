package com.flyingrain.translate.plan.service.services.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/25/17.
 */
public class DayPlan {

    private int id;
    private int user_id;

    private int plan_id;

    private Date complete_time;

    private Date plan_date;

    private int score;

    private String word_ids;

    private String status;

    private Date data_added;

    private Date last_modified;

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

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public Date getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Date complete_time) {
        this.complete_time = complete_time;
    }

    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getWord_ids() {
        return word_ids;
    }

    public void setWord_ids(String word_ids) {
        this.word_ids = word_ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DayPlan{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", plan_id=" + plan_id +
                ", complete_time=" + complete_time +
                ", plan_date=" + plan_date +
                ", score=" + score +
                ", word_ids='" + word_ids + '\'' +
                ", status='" + status + '\'' +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
