package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.beanValidation.annotations.BeanValidation;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import com.flyingrain.translate.plan.api.request.TaskResult;
import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.impl.validations.TaskResourceValidation;
import com.flyingrain.translate.plan.service.services.TaskService;
import com.flyingrain.translate.plan.service.services.TaskSychronize;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
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
    private TaskService taskService;
    @Autowired
    private TaskSychronize taskSychronize;

    @Override
    @BeanValidation(TaskResourceValidation.class)
    public Task getUserPlanTask(Integer planId, Integer userId, String planDate) {
        logger.info("obtain task:planId:[{}],userId:[{}],planDate:[{}]",new Object[]{planId,userId,planDate});
        Date date = new Date();
        if(StringUtils.isNotEmpty(planDate)){
            try {
                date = DateUtils.parseDate(planDate,"yyyy/MM/dd");
            } catch (ParseException e) {
                logger.error("dateFormat error! [{}]",planDate);
                throw new FlyException(PlanExceptionCode.PARAM_INVALID.getCode(),"dateFormat is invalid");
            }
        }
        return taskService.generateTask(userId, planId, date);
    }

    @Override
    public String synchronizeTaskResult(TaskResult taskResult) {
        return taskSychronize.SynchronizeTask(taskResult);

    }


    @Override
    public String generate() {
        taskService.generateTasks();
        logger.info("complete generate!");
        return "generate success!";
    }

}
