package com.flyingrain.translate.plan.service.services.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/25/17.
 */
public class PlanModel {
    private int id;

    private int user_id;

    private int plan_type;

    private Date end_date;

    private Date deadline;

    private int word_number;

    private int all_word_number;

    private int complete_number;

    private int book_id;

    private int status;

    private Date data_added;

    private Date last_modified;

    public int getAll_word_number() {
        return all_word_number;
    }

    public void setAll_word_number(int all_word_number) {
        this.all_word_number = all_word_number;
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

    public int getPlan_type() {
        return plan_type;
    }

    public int getComplete_number() {
        return complete_number;
    }

    public void setComplete_number(int complete_number) {
        this.complete_number = complete_number;
    }

    public void setPlan_type(int plan_type) {
        this.plan_type = plan_type;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
                ", end_date=" + end_date +
                ", deadline=" + deadline +
                ", word_number=" + word_number +
                ", book_id=" + book_id +
                ", status=" + status +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
