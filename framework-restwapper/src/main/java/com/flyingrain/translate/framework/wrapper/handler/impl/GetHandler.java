package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;

/**
 * Created by wally on 4/6/17.
 */
@Component("getHandler")
public class GetHandler implements Handler {
    @Autowired
    @Qualifier("jerseyClient")
    Client client;

    @Override
    public Object dohandle(Request request, Class returnType) {

        //TODO

        Object s = new Object();
        return null;
    }
}
