package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;

/**
 * post请求
 * Created by wally on 6/7/17.
 */
public class PostHandler implements Handler{


    @Override
    public <T> T dohandle(Request request, Class<T> returnType) {
        String url = request.getUrl();

        return null;
    }
}
