package com.flyingrain.translate.plan.api.request;

import java.util.Date;
import java.util.List;

/**
 * 任务完成情况
 * Created by wul on 5/6/17.
 */
public class TaskResult {

    private String taskId;

    private String userId;

    private String status;

    private Date completeDate;

    private List<WordResult> wordResults;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public List<WordResult> getWordResults() {
        return wordResults;
    }

    public void setWordResults(List<WordResult> wordResults) {
        this.wordResults = wordResults;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "taskId='" + taskId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", completeDate=" + completeDate +
                ", wordResults=" + wordResults +
                '}';
    }
}
