package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;

/**
 *
 * 每日计划单词数生成
 * Created by wally on 6/20/17.
 */
public interface DayWordNumberCalculator {

    int calculateDayWordNumber(PlanModel plan);
}
