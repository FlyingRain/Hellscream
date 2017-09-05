package com.flyingrain.translate.framework.beanValidation;

import com.flyingrain.translate.framework.beanValidation.annotations.Validator;
import com.flyingrain.translate.framework.lang.common.Result;

import java.util.List;

/**
 * 参数校验调用链
 * Created by wally on 9/4/17.
 */
public class ValidatorExcutor {

    private List<ValidationConstraint> constraints;

    private final ValidationContext validationContext;

    public ValidatorExcutor(List<ValidationConstraint> constraints, ValidationContext validationContext) {
        constraints.sort((a, b) -> {
            Validator validatorA = a.getClass().getAnnotation(Validator.class);
            Validator validatorB = b.getClass().getAnnotation(Validator.class);
            int orderA = validatorA == null ? -1 : validatorA.order();
            int orderB = validatorB == null ? -1 : validatorB.order();
            return orderA - orderB;
        });
        this.constraints = constraints;
        this.validationContext = validationContext;
    }


    public Result excute() {
        Result validResult = new Result();
        return constraints.stream().map(constraint -> constraint.validate(validationContext)).filter(result -> !result.isSuccess()).reduce((k, l) -> {
            validResult.setMsg(k + ";" + l);
            return validResult;
        }).orElseGet(() -> {
            validResult.setSuccess(true);
            return validResult;
        });
    }

}
