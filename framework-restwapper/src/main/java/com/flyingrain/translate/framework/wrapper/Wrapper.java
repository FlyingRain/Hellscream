package com.flyingrain.translate.framework.wrapper;

/**
 * Created by wally on 4/5/17.
 */
public interface Wrapper {
    /**
     * 包装rest接口
     * @param className
     * @param <T>
     * @return
     */
    <T> T wrapper(Class<T> className);
}
