package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.TaskSychronize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 每日任务
 * Created by wally on 5/4/17.
 */
@Resource
@Component
public class TaskResourceImpl implements TaskResource {
    private Logger logger = LoggerFactory.getLogger(TaskResourceImpl.class);
    @Autowired
    private TaskGenerator taskGenerator;
    @Autowired
    private TaskSychronize taskSychronize;

    @Override
    public Task getUserPlanTask(Integer planId, Integer userId, Date planDate) {
        return taskGenerator.generateTask(userId, planId, planDate);
    }

    @Override
    public String synchronizeTaskResult(TaskResult taskResult) {
        return taskSychronize.SynchronizeTask(taskResult);

    }


}
