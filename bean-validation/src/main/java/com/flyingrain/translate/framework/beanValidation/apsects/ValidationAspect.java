package com.flyingrain.translate.framework.beanValidation.apsects;

import com.flyingrain.translate.framework.beanValidation.ValidationContext;
import com.flyingrain.translate.framework.beanValidation.annotations.BeanValidation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wally on 9/5/17.
 */
@Aspect
@Component
public class ValidationAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Around("@annotation(beanValidation)")
    public Object around(ProceedingJoinPoint joinPoint, BeanValidation beanValidation) throws Throwable {
        Object args[] = joinPoint.getArgs();
        Class targetClass = joinPoint.getSignature().getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ValidationContext context = new ValidationContext(targetClass, args, method);

        return joinPoint.proceed();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

