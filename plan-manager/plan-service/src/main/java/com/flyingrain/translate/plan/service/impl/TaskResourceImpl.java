package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private DayPlanMapper planMapper;

    @Override
    public Task getUserPlanTask(Integer planId, Integer userId, Date planDate) {
        return taskGenerator.generateTask(userId,planId,planDate);
    }

    @Override
    @Transactional
    public String synchronizeTaskResult(TaskResult taskResult) {
        int updateNumber = planMapper.updateTaskStatus(taskResult.getStatus(),taskResult.getTaskId());
        if(updateNumber!=1){
            throw new FlyException(PlanExceptionCode.SYCHRONIZE_PLAN_FAIL.getCode(),PlanExceptionCode.SYCHRONIZE_PLAN_FAIL.getMsg());
        }
        
        return null;
    }
}
