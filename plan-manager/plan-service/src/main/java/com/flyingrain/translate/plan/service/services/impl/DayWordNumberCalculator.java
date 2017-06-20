package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.response.Plan;

/**
 *
 * 每日计划单词数生成
 * Created by wally on 6/20/17.
 */
public interface DayWordNumberCalculator {

    int calculateDayWordNumber(Plan plan,int wordNumber);
}
