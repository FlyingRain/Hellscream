package com.flyingrain.translate.plan.api.request;

import java.util.List;

/**
 * 任务完成情况
 * Created by wul on 5/6/17.
 */
public class TaskResult {

    private int taskId;
    private int userId;
    private int status;

    private String completeDate;

    private List<WordReciteResult> wordReciteResults;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public List<WordReciteResult> getWordReciteResults() {
        return wordReciteResults;
    }

    public void setWordReciteResults(List<WordReciteResult> wordReciteResults) {
        this.wordReciteResults = wordReciteResults;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "taskId='" + taskId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", completeDate=" + completeDate +
                ", wordResults=" + wordReciteResults +
                '}';
    }
}
