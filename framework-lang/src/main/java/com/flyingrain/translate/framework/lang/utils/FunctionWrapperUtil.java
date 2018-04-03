package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.UncheckedFunction;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created on 4/3/18.
 *
 * @author wally
 */
public class FunctionWrapperUtil {


    private static Logger logger = LoggerFactory.getLogger(FunctionWrapperUtil.class);

    /**
     * 包装未受检异常
     *
     * @param uncheckedFunction
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Function<T, R> wrapperUncheckedFunction(UncheckedFunction<T, R> uncheckedFunction) {
        Objects.requireNonNull(uncheckedFunction);
        return t -> {
            try {
                return uncheckedFunction.apply(t);
            } catch (Exception e) {
                logger.error("unchecked function happen exception! className is :[{}]", uncheckedFunction.getClass().getName());
                throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
            }
        };
    }
}
