package com.flyingrain.translate.framework.filter;

import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.lang.common.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * 返回内容过滤器
 * Created by wally on 6/15/17.
 */
public class ResponseFilter implements ContainerResponseFilter {

    private Logger logger = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Object o = responseContext.getEntity();
//        responseContext.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON);
        if (!MediaType.APPLICATION_JSON.equals(responseContext.getHeaderString("Content-Type"))) {
            logger.info("response head is not json,don't filter! header :[{}], response is [{}]",new Object[]{responseContext.getHeaderString("Content-Type"),o});
            return;
        }
        if (!(o instanceof Result)) {
            Result result = new Result();
            result.setSuccess(true);
            result.setCode(ResultType.SUCCESS.getCode());
            result.setMsg(ResultType.SUCCESS.getMsg());
            result.setRealResult(o);
            responseContext.setEntity(result);
        }
    }
}
