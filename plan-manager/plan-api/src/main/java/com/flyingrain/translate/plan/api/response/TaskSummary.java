package com.flyingrain.translate.plan.api.response;

import java.util.Date;

/**
 * task摘要
 */
public class TaskSummary {

    private int planId;

    private int userId;

    private Date taskDate;

    private int newWordsNumber;

    private int oldWordsNumber;

    private int total;

    public int getPlanId() {
        return planId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public int getNewWordsNumber() {
        return newWordsNumber;
    }

    public void setNewWordsNumber(int newWordsNumber) {
        this.newWordsNumber = newWordsNumber;
    }

    public int getOldWordsNumber() {
        return oldWordsNumber;
    }

    public void setOldWordsNumber(int oldWordsNumber) {
        this.oldWordsNumber = oldWordsNumber;
    }

    @Override
    public String toString() {
        return "TaskSummary{" +
                "planId=" + planId +
                ", userId=" + userId +
                ", taskDate=" + taskDate +
                ", newWordsNumber=" + newWordsNumber +
                ", oldWordsNumber=" + oldWordsNumber +
                ", total=" + total +
                '}';
    }
}
