package com.flyingrain.translate.framework.wrapper.handler;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by wally on 4/6/17.
 */
public class Request {

    private String url;

    private Method method;

    private Object params[];


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
