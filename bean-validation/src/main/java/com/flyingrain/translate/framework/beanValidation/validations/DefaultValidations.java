package com.flyingrain.translate.framework.beanValidation.validations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;
import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.common.BeanValidationEnum;
import com.flyingrain.translate.framework.lang.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.stream.Stream;

/**
 * 默认参数校验（JRS-RX）
 * Created by wally on 9/5/17.
 */
@Component
public class DefaultValidations implements ValidationConstraint {

    @Override
    public Result validate(ValidationContext validationContext) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        String validationResult = Stream.of(validationContext.getParams()).flatMap(param -> validator.validate(param).stream())
                .map(constraintViolation-> constraintViolation.getPropertyPath().toString()+":"+constraintViolation.getMessage()).filter(StringUtils::isNotEmpty).reduce((k, l) -> k + ";" + l).orElse("");
        return StringUtils.isEmpty(validationResult) ? new Result(true, "", "") : new Result(false, BeanValidationEnum.INVALID.getCode(), validationResult);
    }
}
