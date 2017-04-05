package com.flyingrain.translate.framework.config;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wally on 4/5/17.
 */
public class MyApplication extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resourceSet = new HashSet<>();
        JerseyConfig.resources.forEach(resource->{
            resourceSet.add(resource);
        });
        return resourceSet;
    }
}
