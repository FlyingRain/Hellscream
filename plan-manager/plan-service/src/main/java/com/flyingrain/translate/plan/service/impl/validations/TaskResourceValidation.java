package com.flyingrain.translate.plan.service.impl.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.PlanService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

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
           DateUtils.parseDate(dateString, "yyyy/MM/dd");
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
