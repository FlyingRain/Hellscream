package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Method;

/**
 * post请求
 * Created by wally on 6/7/17.
 */
@Component("post")
public class PostHandler implements Handler {

    private Logger logger = LoggerFactory.getLogger(PostHandler.class);

    @Value("${flyingrain.token}")
    private String token;

    @Autowired
    @Qualifier("jerseyClient")
    private Client client;

    @Autowired
    private ResultResolver resultResolver;

    /**
     * 构建Post请求
     *
     * @param request
     * @param returnType
     * @param <T>
     * @return
     */
    @Override
    public <T> T doHandle(Request request, Class<T> returnType) {
        Method method = request.getMethod();
        String url = request.getUrl();
        //url="http://localhost:8099/translate/test/webtarget";
        WebTarget webTarget = client.target(url);
        Object params[] = request.getParams();
        Class[] types = method.getParameterTypes();
        if (types.length > 1) {
            logger.error("do not support multiParams!");
            throw new RuntimeException("do not support multiParams!");
        }
        logger.info("start to send Post request :[{}]", params[0]);
        Response response = webTarget.request().header("token", token).buildPost(Entity.entity(params[0], MediaType.APPLICATION_JSON)).invoke();
        //jersey处理genericType的方法
        Result result = response.readEntity(new GenericType<Result>() {
        });
        if (result != null && !result.isSuccess()) {
            throw new FlyException(result.getCode(), result.getMsg());
        }
        return result == null ? null : (T) resultResolver.resolve(result.getRealResult(), method);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
