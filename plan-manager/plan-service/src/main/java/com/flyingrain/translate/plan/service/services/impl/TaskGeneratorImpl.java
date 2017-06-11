package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import com.flyingrain.translate.plan.service.services.common.TaskStatus;
import com.flyingrain.translate.plan.service.services.dao.mapper.DayPlanMapper;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.DayPlan;
import com.flyingrain.translate.plan.service.services.utils.DateUtil;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.request.BookWords;
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
    @Autowired
    private BookQuery bookQuery;
    @Autowired
    private PlanService planService;


    @Override
    public String generateTasks() {
        Date startDate = DateUtil.getTodayZeroDay();
        Date endDate = DateUtil.addDay(startDate,1);
        List<DayPlan> dayPlans = dayPlanMapper.getLatestDayPlans(TaskStatus.COMPLETE.value,startDate,endDate);
        logger.info("start generate [{}] tasks!",dayPlans.size());

        dayPlans.stream()
                .map(dayPlan -> planService.queryPlan(dayPlan.getPlan_id(),dayPlan.getUser_id()))
                .flatMap(List::stream)
                .forEach(plan->{
                    int number = plan.getNumber();
                    if(number!=0){
                        BookWords bookWords = new BookWords();
                        bookWords.setNumber(number);
                        bookWords.setBookId(plan.getBookId());
                        bookWords.setWordIds();
                        bookQuery.
                    }

                });

        dayPlans.forEach(dayPlan -> {
            String planId = dayPlan.

        });


        return null;
    }

    @Override
    public String generateTask(String userId, String planId) {
        return null;
    }
}
