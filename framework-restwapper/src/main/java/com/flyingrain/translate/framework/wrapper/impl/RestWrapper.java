package com.flyingrain.translate.framework.wrapper.impl;

import com.flyingrain.translate.framework.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wally on 4/5/17.
 */
@Component
public class RestWrapper<T> implements Wrapper,InvocationHandler{

    @Autowired
    private Environment environment;


    @Override
    public T wapper(Class className) {
        if(className==null){
            throw new RuntimeException("no resource to be wrapped!");
        }

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{className},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("toString".equals(method.getName())||"equals".equals(method.getName())){
            return method.invoke(proxy,args);
        }
        String url=environment.getProperty("resourceID");
        Path classPath = proxy.getClass().getAnnotation(Path.class);
        Path methodPath = method.getAnnotation(Path.class);
        if(classPath!=null){
            url += classPath.value();
        }
        if(methodPath!=null){
            url += methodPath.value();
        }
        GET get = method.getAnnotation(GET.class);
        POST post = method.getAnnotation(POST.class);
        DELETE delete = method.getAnnotation(DELETE.class);
        PUT put = method.getAnnotation(PUT.class);

        return null;
    }
}
