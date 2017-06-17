package com.flyingrain.translate.plan.service.services;

import com.flyingrain.translate.plan.api.request.TaskResult;

/**
 * 任务同步
 * Created by wally on 6/17/17.
 */
public interface TaskSychronize {

    /**
     * 同步任务完成结果
     * @param result
     * @return
     */
    String SychronizeTask(TaskResult result);
}
