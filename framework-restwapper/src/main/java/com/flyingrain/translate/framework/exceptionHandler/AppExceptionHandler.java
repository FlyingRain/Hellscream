package com.flyingrain.translate.framework.exceptionHandler;

import com.flyingrain.translate.framework.api.param.MyParam;
import com.flyingrain.translate.framework.lang.FlyException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by wally on 6/15/17.
 */
public class AppExceptionHandler implements ExceptionMapper<FlyException>{

    @Override
    public Response toResponse(FlyException exception) {
        MyParam result = new MyParam("1","helloWorld");
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
}
