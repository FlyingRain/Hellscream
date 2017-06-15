package com.flyingrain.translate.framework.filter;

import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.lang.common.ResultType;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * 返回内容过滤器
 * Created by wally on 6/15/17.
 */
public class ResponseFilter implements ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        Object o =responseContext.getEntity();
        if(!(o instanceof Result)){
            Result result = new Result();
            if(o==null){
                result.setSuccess(false);
                result.setCode(ResultType.FAILED.getCode());
                result.setMsg(ResultType.FAILED.getMsg());
            }else{
                result.setSuccess(true);
                result.setCode(ResultType.SUCCESS.getCode());
                result.setMsg(ResultType.SUCCESS.getMsg());
                result.setRealResult(o);
            }
            responseContext.setEntity(result);
        }
    }
}
