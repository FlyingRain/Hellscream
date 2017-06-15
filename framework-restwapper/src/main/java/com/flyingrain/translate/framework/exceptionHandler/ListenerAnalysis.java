package com.flyingrain.translate.framework.exceptionHandler;

import com.flyingrain.translate.framework.FlyExceptionListener;
import com.flyingrain.translate.framework.lang.FlyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 6/15/17.
 */
@Component
public class ListenerAnalysis {

    private Logger logger = LoggerFactory.getLogger(ListenerAnalysis.class);

    protected Class getListenerEventType(FlyExceptionListener listener){
        try {
            return listener.getClass().getMethod("onExceptionHappened").getParameterTypes()[0];
        } catch (NoSuchMethodException e) {
            logger.error("handle FlyException error !",e);
        }
        return null;
    }


}
