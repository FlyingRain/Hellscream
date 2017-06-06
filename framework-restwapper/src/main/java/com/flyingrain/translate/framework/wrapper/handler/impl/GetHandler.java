package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 处理get方法
 * Created by wally on 4/6/17.
 */
@Component("get")
public class GetHandler implements Handler {

    private Logger logger = LoggerFactory.getLogger(GetHandler.class);

    @Autowired
    @Qualifier("jerseyClient")
    Client client;

    @Override
    public Object dohandle(Request request, Class returnType) {

        logger.info("start to send get message : url {[]}",request.getUrl());

        Method method = request.getMethod();
        StringBuilder queryParams = new StringBuilder();

        Annotation[][] annotations = method.getParameterAnnotations();

        Stream.of(annotations).filter(ArrayUtils::isNotEmpty)

        for (Annotation[] a : annotations) {
            if(ArrayUtils.isEmpty(a)){
                continue;
            }
            for (Annotation annotation : a) {
                if(annotation instanceof QueryParam){
                    queryParams.
                }
            }
        }
        //TODO

        Object s = new Object();
        return null;
    }
}
