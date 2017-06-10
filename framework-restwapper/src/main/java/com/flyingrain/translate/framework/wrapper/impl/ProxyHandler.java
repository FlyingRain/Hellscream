package com.flyingrain.translate.framework.wrapper.impl;

import com.flyingrain.translate.framework.common.RestTypeConstants;
import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import javax.ws.rs.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 动态代理处理类
 * Created by wally on 6/10/17.
 */
public class ProxyHandler implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(ProxyHandler.class);

    private Map<String,Handler> handlerMap;

    private Class wrapType;

    private Environment environment;

    public ProxyHandler(Map<String, Handler> handlerMap, Class wrapType, Environment environment) {
        this.handlerMap = handlerMap;
        this.wrapType = wrapType;
        this.environment = environment;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String url = getUrl(wrapType);
        if(StringUtils.isEmpty(url)){
            logger.error("url is null!");
            return null;
        }

        Path classPath = (Path) wrapType.getAnnotation(Path.class);
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

        Request request = new Request();
        request.setMethod(method);
        request.setParams(args);
        request.setUrl(url);

        if(get!=null){
            Handler getHandler = handlerMap.get(RestTypeConstants.GET);
            return getHandler.dohandle(request,method.getReturnType());
        }
        else if(post!=null){
            Handler postHandler = handlerMap.get(RestTypeConstants.POST);
            return postHandler.dohandle(request,method.getReturnType());
        }
        return null;
    }

    private String getUrl(Class proxy) {
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
        String value = temps[1];

        return environment.getProperty(value);
    }
}
