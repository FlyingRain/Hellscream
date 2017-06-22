package com.flyingrain.translate.framework.wrapper.handler.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 返回结果转换
 * Created by wally on 6/22/17.
 */
@Component
public class ResultResolver {

    private Logger logger = LoggerFactory.getLogger(ResultResolver.class);

    /**
     * 通过方法的返回类型转换结果
     *
     * @param returnResult
     * @param method
     * @return
     */
    public Object resolve(Object returnResult, Method method) {
        if (returnResult == null) {
            logger.info("return result is null!");
            return null;
        }
        Type type = method.getGenericReturnType();
        Class returnType = method.getReturnType();
        //如果是参数化类型
        if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
            //如果是集合类型
            if (Collection.class.isAssignableFrom(returnType)) {
                Collection collection = (Collection) returnResult;
                Type[] genericTypes = ((ParameterizedType) type).getActualTypeArguments();
                if (genericTypes.length > 1) {
                    logger.error("not support multi genericType!");
                    throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
                }
                Class elementType;
                //TODO 支持泛型迭代
                try {
                    elementType = Class.forName(genericTypes[0].getTypeName());
                } catch (ClassNotFoundException e) {
                    logger.error("get elementType error! type is [{}]", genericTypes[0].getTypeName());
                    logger.error("exception is ", e);
                    throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
                }
                Collection result = null;
                if (List.class.isAssignableFrom(returnType)) {
                    result = new ArrayList();
                } else if (Set.class.isAssignableFrom(returnType)) {
                    result = new HashSet();
                }
                Collection finalResult = result;
                collection.stream().forEach(co -> {
                    finalResult.add(getElementInstance(co, elementType));
                });
                return finalResult;

            }
        } else if (returnResult instanceof LinkedHashMap && !Map.class.isAssignableFrom(returnType)) {
            return ObjectUtil.mapToObject((Map<String, Object>) returnResult, returnType);
        }
        return returnResult;
    }

    private Object getElementInstance(Object instance, Class type) {
        if (instance instanceof LinkedHashMap) {
            return ObjectUtil.mapToObject((Map<String, Object>) instance, type);
        }
        return instance;
    }
}
