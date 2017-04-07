package com.flyingrain.translate.database.conf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Created by wally on 4/7/17.
 */
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DataSource {
    String value();
}
