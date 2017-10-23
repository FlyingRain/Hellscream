package com.flyingrain.translate.plan.service.services.impl.tasks;

import com.flyingrain.translate.plan.api.response.Task;

import java.util.Date;

/**
 * Created by wally on 10/23/17.
 */
public interface TaskGenerator {

    /**
     * 根据用户Id,计划Id,日期,生成每日任务
     * @param userId
     * @param planId
     * @param planDate
     * @return
     */
    Task generateTask(int userId, int planId, Date planDate);
}
