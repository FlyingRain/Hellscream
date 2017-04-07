package com.flyingrain.translate.database.conf;

import java.lang.annotation.*;

/**
 * Created by wally on 4/7/17.
 */
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value();
}
