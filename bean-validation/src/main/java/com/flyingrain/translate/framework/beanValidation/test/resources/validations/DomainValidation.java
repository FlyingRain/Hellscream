package com.flyingrain.translate.framework.beanValidation.test.resources.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.test.resources.domain.TestDomain;
import com.flyingrain.translate.framework.lang.common.Result;

/**
 * Created by wally on 9/6/17.
 */
public class DomainValidation implements ValidationConstraint{

    @Override
    public Result validate(ValidationContext validationContext) {
        Result validationResult = new Result();
        Object[] params =validationContext.getParams();
        TestDomain testDomain = (TestDomain) params[0];
        if(testDomain.getAge()<18){
            validationResult.setSuccess(false);
            validationResult.setMsg("未成年人不得入内");
        }
        return validationResult;
    }
}
