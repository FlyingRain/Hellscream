package com.flyingrain.translate.plan.service.services.impl.tasks;

import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;

import java.util.Date;

/**
 * Created by wally on 10/23/17.
 */
public interface TaskGenerator {

    /**
     * 根据用户Id,计划Id,日期,生成每日任务
     * @param userId
     * @param planModel
     * @param planDate
     * @return
     */
    Task generateTask(int userId, PlanModel planModel, Date planDate);
}
