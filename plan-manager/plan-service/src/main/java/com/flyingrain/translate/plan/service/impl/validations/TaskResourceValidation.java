package com.flyingrain.translate.plan.service.impl.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.lang.utils.DateUtil;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.PlanService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取每日任务参数校验
 * Created by wally on 9/6/17.
 */
@Component
public class TaskResourceValidation implements ValidationConstraint {

    @Autowired
    private PlanService planService;


    @Override
    public Result validate(ValidationContext validationContext) {
        Object params[] = validationContext.getParams();

        Integer planId = (Integer) params[0];
        Integer userId = (Integer) params[1];
        String dateString = (String) params[2];
        StringBuilder validatResult = new StringBuilder();
        Plan plan = planService.getUserPlan(userId, planId);
        try {
           Date date = DateUtils.parseDate(dateString, "yyyy/MM/dd");
           Date today = DateUtil.getTodayZeroDay();
           //在今天之前
           if(DateUtils.truncatedCompareTo(date,today, Calendar.SECOND)<0){
               validatResult.append("date is wrong!can't get tasks before today!");
           }
        } catch (ParseException e) {
            validatResult.append("dateFormat is wrong;");
        }
        if (plan == null) {
            validatResult.append("the plan of user doesn't exist;");
        }
        if (StringUtils.isEmpty(validatResult)) {
            return Result.success();
        }
        return Result.fail(PlanExceptionCode.PARAM_INVALID.getCode(), validatResult.toString());
    }
}
