package com.flyingrain.translate.framework.beanValidation.annotations;

import com.flyingrain.translate.framework.beanValidation.ValidationConstraint;

import java.lang.annotation.*;

/**
 * 参数校验
 * Created by wally on 17-9-3.
 */
@Inherited
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanValidation {

    /**
     * 校验规则
     * @return
     */
    Class<? extends ValidationConstraint>[] value() default {};

    /**
     * 执行顺序
     * @return
     */
    int order() default -1;

}
