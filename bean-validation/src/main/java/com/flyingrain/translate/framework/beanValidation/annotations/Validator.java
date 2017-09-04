package com.flyingrain.translate.framework.beanValidation.annotations;

import sun.invoke.empty.Empty;

import java.lang.annotation.*;

/**
 * Created by wally on 9/4/17.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Validator {

    /**
     * 目标类
     * @return
     */
    Class<?> target() default Empty.class;

    /**
     * 目标方法
     * @return
     */
    String methodName() default "";

    /**
     * 优先级
     * @return
     */
    int order() default -1;
}
