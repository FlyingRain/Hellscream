package com.flyingrain.translate.framework.wrapper.handler;

/**
 * Created by wally on 4/6/17.
 */
public interface Handler {

    <T> T dohandle(Request request,Class<T> returnType);

}
