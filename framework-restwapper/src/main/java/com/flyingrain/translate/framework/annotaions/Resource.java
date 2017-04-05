package com.flyingrain.translate.framework.annotaions;

import java.lang.annotation.*;

/**
 * Created by wally on 4/5/17.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Resource {
    String value() default "";

}
