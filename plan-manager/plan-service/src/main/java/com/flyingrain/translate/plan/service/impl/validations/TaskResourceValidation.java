package com.flyingrain.translate.plan.service.impl.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.lang.common.Result;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 9/6/17.
 */
@Component
public class TaskResourceValidation implements ValidationConstraint{
    @Override
    public Result validate(ValidationContext validationContext) {
        Object params[] = validationContext.getParams();
        Integer planId = (Integer) params[0];
        Integer userId = (Integer) params[1];
        String date = (String) params[2];


        return null;
    }
}
