package com.flyingrain.translate.framework.wrapper.impl;

import com.flyingrain.translate.framework.common.RestTypeConstants;
import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * Created by wally on 4/5/17.
 */
@Component
public class RestWrapper implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(RestWrapper.class);

    private static Environment environment;

    @Autowired
    private Map<String,Handler> handlerMap;


    public <T> T  wrapper(Class<T> className) {
        if (className == null) {
            throw new RuntimeException("no resource to be wrapped!");
        }
        logger.info("wrapper interface [{}]",className.getName());
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{className}, new ProxyHandler(handlerMap,className,environment));
    }

    @Override
    public void setEnvironment(Environment environment) {
        RestWrapper.environment = environment;
    }
}
