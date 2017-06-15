package com.flyingrain.translate.framework;

import com.flyingrain.translate.framework.lang.FlyException;

/**
 * Created by wally on 6/15/17.
 */
public interface FlyExceptionListener<T> {

    void onExceptionHappened(T event);

}
