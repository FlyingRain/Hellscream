package com.flyingrain.translate.framework.lang;

/**
 * Created on 4/3/18.
 * 抛出未受检异常的函数
 * @author wally
 */
@FunctionalInterface
public interface UncheckedFunction<T, R> {

    R apply(T t) throws Exception;
}
