package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public <T> T doHandle(Request request, Class<T> returnType) {
        String url = getUrl(request);
        logger.info("start to send get message : url {[]}", url);
        WebTarget target = client.target(url);
        //jersey处理genericType的方法
        Response response = target.request().get();
        Result result = response.readEntity(new GenericType<Result>(){});
        logger.info("get response {[]}",result);
        if(result.getRealResult()!=null && result.getRealResult() instanceof LinkedHashMap){
            logger.info("get response from server:[{}]",result.getRealResult());
            return ObjectUtil.mapToObject((Map<String, Object>) result.getRealResult(),returnType);
        }
        return (T) result.getRealResult();

    }


    /**
     * 解析url
     * @param request 请求参数
     * @return
     */
    private String getUrl(Request request) {
        Method method = request.getMethod();
        Object params[] = request.getParams();
        String url = request.getUrl();

        StringBuilder queryParams = new StringBuilder();

        Annotation[][] annotations = method.getParameterAnnotations();

        //拼接get请求
        for (int i = 0; i < annotations.length; i++) {
            Annotation[] paramAnnotation = annotations[i];
            if (ArrayUtils.isNotEmpty(paramAnnotation)) {
                for (Annotation a : paramAnnotation) {
                    if (a instanceof QueryParam) {
                        queryParams.append(((QueryParam) a).value()).append("=").append(params[i].toString()).append("&");
                    } else if (a instanceof PathParam) {
                        String key = ((PathParam) a).value();
                        url = url.replace("{" + key + "}", params[i].toString());
                    }
                }
            }
        }

        String queryString = queryParams.toString();
        if (StringUtils.isNotEmpty(queryParams)) {
            queryString = queryString.substring(0, queryString.length() - 1);
        }
        url = url + "?" + queryString;
        return url;
    }

}
