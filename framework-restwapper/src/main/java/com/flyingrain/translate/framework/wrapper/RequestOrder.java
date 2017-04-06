package com.flyingrain.translate.framework.wrapper;

import com.flyingrain.translate.framework.wrapper.handler.Handler;
import com.flyingrain.translate.framework.wrapper.handler.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 4/6/17.
 */
public class RequestOrder<T> {

    private Logger logger = LoggerFactory.getLogger(RequestOrder.class);

    private String orderName;

    private Handler handler;

    private Request request;


    public T doRequest(Class<T> type){
        logger.info("start to send request:" + request);
        T result = (T) handler.dohandle(request,type);
        return result;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
