package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Method;

/**
 * post请求
 * Created by wally on 6/7/17.
 */
@Component("post")
public class PostHandler implements Handler{

    private Logger logger = LoggerFactory.getLogger(PostHandler.class);

    @Autowired
    @Qualifier("jerseyClient")
    private Client client;

    /**
     * 构建Post请求
     * @param request
     * @param returnType
     * @param <T>
     * @return
     */
    @Override
    public <T> T dohandle(Request request, Class<T> returnType) {
        Method method = request.getMethod();
        String url = request.getUrl();
        WebTarget webTarget = client.target(url);
        Object params[] = request.getParams();
        Class [] types = method.getParameterTypes();
        if(types.length>1){
            logger.error("do not support multiParams!");
            throw new RuntimeException("do not support multiParams!");
        }
        logger.info("start to send Post request :[{}]",params[0]);
        Response response = webTarget.request().buildPost(Entity.entity(params[0], MediaType.APPLICATION_JSON)).invoke();
        return response.readEntity(returnType);
    }
}
