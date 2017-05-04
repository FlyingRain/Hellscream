package com.flyingrain.translate.plan.service.services.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/25/17.
 */
public class PlanModel {
    private String id;

    private String user_id;

    private int plan_type;

    private Date endDate;

    private Date deadline;

    private int word_number;

    private int book_id;

    private int status;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(int plan_type) {
        this.plan_type = plan_type;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getWord_number() {
        return word_number;
    }

    public void setWord_number(int word_number) {
        this.word_number = word_number;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlanModel{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", plan_type=" + plan_type +
                ", endDate=" + endDate +
                ", deadline=" + deadline +
                ", word_number=" + word_number +
                ", book_id=" + book_id +
                ", status=" + status +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
