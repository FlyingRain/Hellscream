package com.flyingrain.translate.framework.beanValidation;

import java.lang.annotation.Annotation;

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
     * 方法名
     */
    private String methodName;

    /**
     * 注解
     */
    private Annotation annotation;

    public ValidationContext(Class<?> targetClass, Object[] params, String methodName, Annotation annotation) {
        this.targetClass = targetClass;
        this.params = params;
        this.methodName = methodName;
        this.annotation = annotation;
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

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }
}
