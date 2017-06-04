package com.flyingrain.translate.framework.wrapper.impl;

import com.flyingrain.translate.framework.wrapper.Wrapper;
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

/**
 * Created by wally on 4/5/17.
 */
@Component
public class RestWrapper implements InvocationHandler,EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(RestWrapper.class);

    private static Environment environment;

    public static <T> T  wrapper(Class<T> className) {
        if (className == null) {
            throw new RuntimeException("no resource to be wrapped!");
        }

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{className}, new RestWrapper(className));
    }

    public RestWrapper() {
    }

    private Class wrapType;

    public RestWrapper(Class wrapType) {
        this.wrapType = wrapType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("toString".equals(method.getName()) || "equals".equals(method.getName())) {
            return method.invoke(proxy, args);
        }
        String url = getUrl(wrapType);
        if(StringUtils.isEmpty(url)){
            logger.error("url is null!");
            return null;
        }

        Path classPath = proxy.getClass().getAnnotation(Path.class);
        Path methodPath = method.getAnnotation(Path.class);
        if (classPath != null) {
            url += classPath.value();
        }
        if (methodPath != null) {
            url += methodPath.value();
        }
        GET get = method.getAnnotation(GET.class);
        POST post = method.getAnnotation(POST.class);
        DELETE delete = method.getAnnotation(DELETE.class);
        PUT put = method.getAnnotation(PUT.class);

        return null;
    }


    private String getUrl(Class proxy) {
        String url = "";

        InputStream inputStream = proxy.getClass().getResourceAsStream("/config/apiConfig.properties");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String nameAndValue = null;
        try {
            nameAndValue = reader.readLine();
        } catch (IOException e) {
            logger.error("read file failed!",e);
        }
        String temps[] = nameAndValue.split("=");
        if (temps.length < 2) {
            throw new RuntimeException("error apiConfig!" + nameAndValue);
        }
        String name = temps[0];
        String value = temps[1];

        return environment.getProperty(value);
    }

    @Override
    public void setEnvironment(Environment environment) {
        RestWrapper.environment = environment;
    }
}
