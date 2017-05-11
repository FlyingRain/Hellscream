package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.common.TaskStatus;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.flyingrain.translate.plan.service.services.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by wally on 5/10/17.
 */
@Component
public class TaskGeneratorImpl implements TaskGenerator {

    private Logger logger = LoggerFactory.getLogger(TaskGeneratorImpl.class);

    @Autowired
    private DayPlanMapper dayPlanMapper;
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;


    @Override
    public String generateTasks() {
        Date startDate = DateUtil.getTodayZeroDay();
        Date endDate = DateUtil.addDay(startDate,1);
        List<DayPlan> dayPlans = dayPlanMapper.getLatestDayPlans(TaskStatus.COMPLETE.value,startDate,endDate);
        logger.info("start generate [{}] tasks!",dayPlans.size());

        return null;
    }

    @Override
    public String generateTask(String userId, String planId) {
        return null;
    }
}
