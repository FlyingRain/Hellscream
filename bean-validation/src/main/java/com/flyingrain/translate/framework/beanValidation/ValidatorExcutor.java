package com.flyingrain.translate.framework.beanValidation;

import com.flyingrain.translate.framework.beanValidation.annotations.Validator;
import com.flyingrain.translate.framework.lang.common.Result;

import java.util.List;

/**
 * Created by wally on 9/4/17.
 */
public class ValidatorExcutor {

    List<ValidationConstraint> constraints;

    public ValidatorExcutor(List<ValidationConstraint> constraints) {
        constraints.sort((a, b) -> {
            Validator validatorA = a.getClass().getAnnotation(Validator.class);
            Validator validatorB = b.getClass().getAnnotation(Validator.class);
            int orderA = validatorA == null ? -1 : validatorA.order();
            int orderB = validatorB == null ? -1 : validatorB.order();
            return orderA - orderB;
        });
        this.constraints = constraints;
    }


    public Result excute() {
        return null;
    }

}
