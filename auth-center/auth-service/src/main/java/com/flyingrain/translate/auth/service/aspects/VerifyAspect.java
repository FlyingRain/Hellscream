package com.flyingrain.translate.auth.service.aspects;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.VerifyService;
import com.flyingrain.translate.framework.lang.FlyException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 8/3/17.
 */
@Aspect
@Component
public class VerifyAspect {

    private Logger logger = LoggerFactory.getLogger(VerifyAspect.class);

    @Autowired
    private VerifyService verifyService;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.flyingrain.translate.auth.service.annotations.VerifySign)")
    public void getPoint() {
    }


    @Before("getPoint()")
    public void advice(JoinPoint joinPoint) {
        logger.info("intercept request :[{}]", joinPoint.getSignature().getName());
        Object[] params = joinPoint.getArgs();
        if (params == null || params.length != 1 || !(params[0] instanceof VerifyRequest)) {
            logger.error("error param!");
            throw new FlyException(AuthError.PARASEFAIL.getCode(), AuthError.PARASEFAIL.getMsg());
        }
        VerifyRequest request = (VerifyRequest) params[0];
        if (!verifyService.verifySign(request)) {
            logger.error("verify sign error!");
            throw new FlyException(AuthError.VERIFYSIGNFAIL.getCode(), AuthError.VERIFYSIGNFAIL.getMsg());
        }
    }

}
