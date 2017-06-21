package com.flyingrain.translate.framework.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 请求过滤器
 * Created by wally on 6/21/17.
 */
public class RequestFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getPropertyNames();
        InputStream inputStream = requestContext.getEntityStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String request = reader.readLine();
    }
}
