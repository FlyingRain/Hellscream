package com.flyingrain.translate.framework.beanValidation;

import java.lang.reflect.Method;

/**
 * 参数校验上下文
 * Created by wally on 17-9-3.
 */
public class ValidationContext {

    /**
     * 目标类
     */
    private Class<?> targetClass;
    /**
     * 入参
     */
    private Object [] params;
    /**
     * 方法
     */
    private Method method;

    public ValidationContext(Class<?> targetClass, Object[] params, Method method) {
        this.targetClass = targetClass;
        this.params = params;
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
