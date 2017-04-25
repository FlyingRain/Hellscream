package com.flyingrain.translate.plan.api.request;

import java.util.Date;

/**
 * 新建计划
 * Created by wally on 4/25/17.
 */
public class PlanRequest {
    /**
     * 书本ID
     */
    private String bookId;
    /**
     * 计划类型1，按时间2，按数量
     */
    private int planType;
    /**
     * 截止日期
     */
    private Date deadline;
    /**
     * 每日单词数量
     */
    private int number;
    /**
     * 用户ID
     */
    private int userId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
