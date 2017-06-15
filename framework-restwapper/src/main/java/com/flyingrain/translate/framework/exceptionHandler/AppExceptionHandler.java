package com.flyingrain.translate.framework.exceptionHandler;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.Result;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * 统一异常处理器
 * Created by wally on 6/15/17.
 */
public class AppExceptionHandler implements ExceptionMapper<FlyException>{

    @Override
    public Response toResponse(FlyException exception) {
        Result result = new Result(exception.getExCode(),exception.getExMsg());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
}
