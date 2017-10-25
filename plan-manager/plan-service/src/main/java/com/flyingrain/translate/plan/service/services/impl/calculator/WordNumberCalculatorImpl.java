package com.flyingrain.translate.plan.service.services.impl.calculator;

import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.service.services.dao.mapper.UserWordRelationMapper;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.plan.service.services.impl.DayWordNumberCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by wally on 6/20/17.
 */
@Component
public class WordNumberCalculatorImpl implements DayWordNumberCalculator {
    @Autowired
    private UserWordRelationMapper userWordRelationMapper;

    @Override
    public int calculateDayWordNumber(PlanModel plan) {
        Date deadline = plan.getDeadline();
        Date today = DateUtil.getTodayZeroDay();
        int number = (int) ChronoUnit.DAYS.between(today.toInstant(), deadline.toInstant());
        int wordNumber = userWordRelationMapper.getUserRecitedNumber(plan.getUser_id(), plan.getId());
        int leftWord = plan.getAll_word_number() - wordNumber;

        return (leftWord / number);
    }
}
