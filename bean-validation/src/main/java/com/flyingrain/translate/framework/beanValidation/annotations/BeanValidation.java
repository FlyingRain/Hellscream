package com.flyingrain.translate.framework.beanValidation.annotations;

import java.lang.annotation.*;

/**
 * 参数校验
 * Created by wally on 17-9-3.
 */
@Inherited
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanValidation {


}
