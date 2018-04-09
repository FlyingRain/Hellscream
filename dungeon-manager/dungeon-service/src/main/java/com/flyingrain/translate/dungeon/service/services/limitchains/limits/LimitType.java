package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import java.lang.annotation.*;

/**
 * Created on 4/4/18.
 *
 * @author wally
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LimitType {

    String value();
}
