package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.common.ExceptionEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.AbstractLimit;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitType;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.utils.JavaClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 3/30/18.
 *
 * @author wally
 */
@Component
public class LimitLoader {

    private Logger logger = LoggerFactory.getLogger(LimitLoader.class);

    private static final String PACKAGENAME = "com.flyingrain.translate.dungeon.service.services.limitchains.limits";

    private Map<String, Class<AbstractLimit>> limitModelsCache;

    public Map<String, Class<AbstractLimit>> loadLimitModels() {

        List<Class<?>> classes;
        try {
            classes = JavaClassLoader.loadClasses(PACKAGENAME, Thread.currentThread().getContextClassLoader());
        } catch (IOException | URISyntaxException e) {
            logger.error("load class error!", e);
            throw new FlyException(ExceptionEnum.LIMITTYPEERROR.getCode(), ExceptionEnum.LIMITTYPEERROR.getDesc());
        }
        Map<String, Optional<Class<?>>> limitClasses = classes.stream().filter(AbstractLimit.class::isAssignableFrom).collect(Collectors.groupingBy(a -> Objects.requireNonNull(a.getDeclaredAnnotation(LimitType.class)).value(), Collectors.mapping(l -> l, Collectors.reducing((l, r) -> l))));
        Map<String,Class<AbstractLimit>> loadedClasses= new HashMap<>();
        limitClasses.forEach((k,v)-> loadedClasses.put(k,((Class<AbstractLimit>) v.orElse(null))));
        return loadedClasses;

    }
}
