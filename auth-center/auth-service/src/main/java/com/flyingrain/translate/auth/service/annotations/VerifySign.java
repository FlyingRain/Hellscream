package com.flyingrain.translate.auth.service.annotations;

import java.lang.annotation.*;

/**
 * Created by wally on 8/3/17.
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifySign {
    String value() default "";
}
