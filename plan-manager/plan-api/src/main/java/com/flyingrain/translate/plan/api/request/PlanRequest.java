package com.flyingrain.translate.plan.api.request;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 新建计划
 * Created by wally on 4/25/17.
 */
public class PlanRequest {
    /**
     * 书本ID
     */
    @NotBlank
    private int bookId;

    /**
     * 计划类型1，按时间2，按数量
     */
    @NotBlank
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
    @NotBlank
    private int userId;



    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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