package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Result;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 每日任务
 * Created by wally on 5/4/17.
 */
@Resource
@Component
public class TaskResourceImpl implements TaskResource{

    @Autowired
    private TaskGenerator taskGenerator;

    @Override
    public Result<Task> getUserPlanTask(Integer planId, Integer userId, Date planDate) {


        Task task = taskGenerator.generateTask(userId,planId,planDate);
        return new Result<>("00","success",task);
    }

    @Override
    public Result<String> synchronizeTaskResult(TaskResult taskResult) {
        return null;
    }
}
