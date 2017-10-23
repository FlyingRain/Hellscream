package com.flyingrain.translate.plan.service.impl.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.service.common.PlanExceptionCode;
import com.flyingrain.translate.plan.service.services.PlanService;
import com.flyingrain.translate.plan.service.services.common.PlanType;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class PlanExistValidation implements ValidationConstraint {

    @Autowired
    private PlanService planService;

    @Override
    public Result validate(ValidationContext validationContext) {
        Object[] params=validationContext.getParams();
        PlanRequest request =(PlanRequest) params[0];
        int planId = request.getId();
        int planType = request.getPlanType();
        planService.queryPlan(planId,0);
        if(planType== PlanType.BYDEADLINE.getType()){
            try {
                DateUtils.parseDate(request.getDeadline(),"yyyy/MM/dd");
            } catch (ParseException e) {
                return Result.fail(PlanExceptionCode.PARAM_INVALID.getCode(),"date format is invalid!");
            }
        }

        return Result.success();
    }
}
