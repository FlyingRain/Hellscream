package com.flyingrain.translate.plan.service.services.impl.tasks;

import com.flyingrain.translate.plan.api.response.Task;

import java.util.Date;

/**
 * 基于固定日期生成每日计划
 * Created by wally on 10/23/17.
 */
public class DateBasedTaskGenerator implements TaskGenerator{
    @Override
    public Task generateTask(int userId, int planId, Date planDate) {
        return null;
    }
}
