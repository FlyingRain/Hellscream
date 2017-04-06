package com.flyingrain.translate.framework.wrapper.handler;

import java.util.Map;

/**
 * Created by wally on 4/6/17.
 */
public class Request {

    private String url;

    private String type;

    private Map<String,String> queryParam;

    private Map<String,String> pathParam;

    private Map param;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, String> queryParam) {
        this.queryParam = queryParam;
    }

    public Map<String, String> getPathParam() {
        return pathParam;
    }

    public void setPathParam(Map<String, String> pathParam) {
        this.pathParam = pathParam;
    }

    public Map getParam() {
        return param;
    }

    public void setParam(Map param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", queryParam=" + queryParam +
                ", pathParam=" + pathParam +
                ", param=" + param +
                '}';
    }
}
