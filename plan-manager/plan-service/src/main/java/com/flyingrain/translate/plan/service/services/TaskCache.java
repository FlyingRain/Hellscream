package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.response.Task;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;

/**
 * Created by wally on 6/13/17.
 */
public interface TaskCache {

    /**
     * 从缓存中获取任务
     * @param dayPlan
     * @return
     */
    Task getTask(DayPlan dayPlan);

    /**
     * 缓存任务
     * @param task
     * @param dayPlan
     */
    void cacheTask(Task task,DayPlan dayPlan);
}
