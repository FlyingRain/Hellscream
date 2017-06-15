package com.flyingrain.translate.framework.exceptionHandler;

import com.flyingrain.translate.framework.FlyExceptionListener;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 异常监听器管理类
 * Created by wally on 6/15/17.
 */
@Component
public class FlyExceptionListenerManager {

    private Set<FlyExceptionListener> listeners = new LinkedHashSet<>();


    private void registerListener(FlyExceptionListener listener){
        listeners.add(listener);
    }
}
