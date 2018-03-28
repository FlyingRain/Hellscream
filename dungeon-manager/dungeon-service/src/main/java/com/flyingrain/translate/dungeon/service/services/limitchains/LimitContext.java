package com.flyingrain.translate.dungeon.service.services.limitchains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 18-3-24.
 *
 * @author wally
 */
public class LimitContext {

    private static Logger logger = LoggerFactory.getLogger(LimitContext.class);

    private static ThreadLocal<Map<String, Object>> context = new ThreadLocal<>();


    public static Object get(String key) {
        return context.get() != null ? context.get().get(key) : null;
    }

    public static Object put(String key, Object o) {
        Object object = context.get().get(key);
        if (object == null) {
            Map<String, Object> map = context.get() == null ? new HashMap<>() : context.get();
            map.put(key, o);
            return null;
        } else {
            logger.info("key had exited![{}]", object);
            return object;
        }
    }


}
