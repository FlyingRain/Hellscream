package com.flyingrain.translate.framework.beanValidation;

import java.lang.reflect.Method;

/**
 * 参数校验上下文
 * Created by wally on 17-9-3.
 */
public class ValidationContext {

    /**
     * 入参
     */
    private Object [] params;
    /**
     * 方法
     */
    private Method method;

    public Object[] getParams() {
        return params;
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
