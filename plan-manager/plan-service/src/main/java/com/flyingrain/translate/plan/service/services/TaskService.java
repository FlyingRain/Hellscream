package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.api.response.TaskSummary;

import java.util.Date;

/**
 * Created by wally on 5/4/17.
 */
public interface TaskService {

    /**
     * 生成已返回计划状态的下一天计划
      * @return
     */
    String generateTasks();

    Task generateTask(int userId, int planId,Date planDate);

    /**
     * 获取任务摘要
     * @param userId
     * @param planId
     * @param planDate
     * @return
     */
    TaskSummary getTaskSummary(int userId,int planId,Date planDate);

}
