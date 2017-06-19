package com.flyingrain.translate.framework.exceptionHandler;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import com.flyingrain.translate.framework.lang.common.Result;
import org.eclipse.jetty.util.log.LoggerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * 统一异常处理器
 * Created by wally on 6/15/17.
 */
public class AppExceptionHandler implements ExceptionMapper<Exception> {

    private Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @Override
    public Response toResponse(Exception exception) {
        Result result;
        if (exception instanceof FlyException) {
            FlyException flyException = (FlyException) exception;
            result = new Result(flyException.getExCode(), flyException.getExMsg());
        } else {
            result = new Result(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }
        logger.error("sys happen exception!",exception);
        logger.info("return msg: [{}]",result);
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();

    }
}
