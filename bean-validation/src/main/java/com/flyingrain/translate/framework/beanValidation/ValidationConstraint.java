package com.flyingrain.translate.framework.beanValidation;

import com.flyingrain.translate.framework.lang.common.Result;

/**
 * 校验
 * Created by wally on 17-9-3.
 */
@FunctionalInterface
public interface ValidationConstraint {

    Result validate(ValidationContext validationContext);
}
