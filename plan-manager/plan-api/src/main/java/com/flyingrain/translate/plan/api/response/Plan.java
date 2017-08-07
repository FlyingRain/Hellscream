package com.flyingrain.translate.plan.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by wally on 4/25/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plan {
    private int id;

    private int planType;

    private int userId;


    private int planStatus;

    private Date deadline;

    /**
     * 已完成的单词数量
     */
    private int completeNumber;

    /**
     * 单词总量
     */
    private int allNumber;

    private Date endDate;

    private int bookId;

    private String bookName;

    /**
     * 计划每日背诵的单词数量
     */
    private int number;

    public int getId() {
        return id;
    }

    public Plan setId(int id) {
        this.id = id;
        return this;
    }

    public int getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(int allNumber) {
        this.allNumber = allNumber;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }

    public int getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(int planStatus) {
        this.planStatus = planStatus;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Plan setDeadline(Date deadline) {
        this.deadline = deadline;
        return this;
    }

    public int getCompleteNumber() {
        return completeNumber;
    }

    public void setCompleteNumber(int completeNumber) {
        this.completeNumber = completeNumber;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
