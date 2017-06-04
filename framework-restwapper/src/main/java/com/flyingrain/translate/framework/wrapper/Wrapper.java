package com.flyingrain.translate.framework.wrapper;

/**
 * Created by wally on 4/5/17.
 */
public interface Wrapper {

    <T> T wrapper(Class<T> className);
}
