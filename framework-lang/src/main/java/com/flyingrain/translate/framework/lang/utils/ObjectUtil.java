package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Stream;

/**
 * 对象工具类
 * Created by wally on 6/16/17.
 */
public class ObjectUtil {

    private static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    /**
     * 将map转化为对象
     *
     * @param map
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T mapToObject(Map<String, Object> map, Class<T> object) {
        T instance;
        try {
            instance = object.newInstance();
        } catch (InstantiationException e) {
            logger.error("instance object failed! className is :[{}]", object.getName());
            logger.error("exception is ", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        } catch (IllegalAccessException e) {
            logger.error("error happened!", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }

        Stream.of(object.getDeclaredFields()).filter(field -> (map.get(field.getName()) != null)).forEach(field -> {
            try {
                field.setAccessible(true);
                Object value = map.get(field.getName());
                //如果是对象则递归赋值
                if (value instanceof LinkedHashMap && !Map.class.isAssignableFrom(field.getType())) {
                    value = mapToObject((Map<String, Object>) value, field.getType());
                }
                Type type = field.getGenericType();
                if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        Type genericTypes[] = ((ParameterizedType) type).getActualTypeArguments();
                        if(genericTypes.length>1){
                            logger.error("not support this structure!");
                            throw new FlyException(FrameworkExceptionCode.NOTSUPPORT.getCode(),FrameworkExceptionCode.NOTSUPPORT.getMsg());
                        }
                        Class genericType;
                        try {
                            genericType = Class.forName(genericTypes[0].getTypeName());
                        } catch (ClassNotFoundException e) {
                            logger.error("not support this structure", e);
                            throw new FlyException(FrameworkExceptionCode.NOTSUPPORT.getCode(), FrameworkExceptionCode.NOTSUPPORT.getMsg());
                        }
                        Collection realValue;
                        if (List.class.isAssignableFrom(field.getType())) {
                            realValue = new ArrayList();
                        } else if (Set.class.isAssignableFrom(field.getType())) {
                            realValue = new HashSet();
                        } else {
                            throw new FlyException(FrameworkExceptionCode.NOTSUPPORT.getCode(), FrameworkExceptionCode.NOTSUPPORT.getMsg());
                        }
                        ((Collection) value).stream().filter(v-> v instanceof Map).map(v -> mapToObject((Map<String, Object>) v, genericType)).forEach(realValue::add);
                        ((Collection) value).stream().filter(v-> !(v instanceof Map)).forEach(realValue::add);
                        value = realValue;
                    }
                }
                field.set(instance, value);
            } catch (IllegalAccessException e) {
                logger.error("set value to instance failed!", e);
                throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
            }
        });
        return instance;
    }


}
