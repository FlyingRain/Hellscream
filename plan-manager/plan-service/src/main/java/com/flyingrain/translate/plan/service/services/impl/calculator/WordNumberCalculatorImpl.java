package com.flyingrain.translate.plan.service.services.impl.calculator;

import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.services.impl.DayWordNumberCalculator;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by wally on 6/20/17.
 *
 */
@Component
public class WordNumberCalculatorImpl implements DayWordNumberCalculator{



    @Override
    public int calculateDayWordNumber(Plan plan,int wordNumber) {
        Date deadline = plan.getDeadline();
        Date today = DateUtil.getTodayZeroDay();
        int number = (int) ChronoUnit.DAYS.between(today.toInstant(),deadline.toInstant());
        int leftWord = plan.getAllNumber()-wordNumber;

        return (leftWord/number);
    }
}
