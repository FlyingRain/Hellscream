package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 对象工具类
 * Created by wally on 6/16/17.
 */
public class ObjectUtil {

    private static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);
    /**
     * 将map转化为对象
     * @param map
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T mapToObject(Map<String,Object> map,Class<T> object){
        T instance ;
        try {
            instance = object.newInstance();
        } catch (InstantiationException e) {
            logger.error("instance object failed! className is :[{}]",object.getName());
            logger.error("exception is ",e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
        } catch (IllegalAccessException e) {
            logger.error("error happened!",e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
        }

        Stream.of(object.getDeclaredFields()).filter(field->(map.get(field.getName())!=null)).forEach(field -> {
            try {
                field.setAccessible(true);
                field.set(instance,map.get(field.getName()));
            } catch (IllegalAccessException e) {
                logger.error("set value to instance failed!",e);
                throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
            }
        });
        return instance;
    }


}
