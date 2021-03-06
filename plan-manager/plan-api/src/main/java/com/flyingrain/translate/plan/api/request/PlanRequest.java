package com.flyingrain.translate.plan.api.request;

/**
 * 新建计划
 * Created by wally on 4/25/17.
 */
public class PlanRequest {

    /**
     * 计划Id
     */
    private int id;
    /**
     * 书本ID
     */
    private int bookId;

    /**
     * 计划类型1，按数量2，按时间
     */
    private int planType;
    /**
     * 截止日期
     */
    private String deadline;
    /**
     * 每日单词数量
     */
    private int number;
    /**
     * 用户ID
     */
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PlanRequest{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", planType=" + planType +
                ", deadline=" + deadline +
                ", number=" + number +
                ", userId=" + userId +
                '}';
    }
}
