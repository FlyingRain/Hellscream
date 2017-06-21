package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * 内部资源加载器
 * Created by wally on 6/21/17.
 */
public class ResourceLoader {

    private static final String LOADPATH="config/apiConfig.properties";

    private static Logger logger = LoggerFactory.getLogger(ResourceLoader.class);
    /**
     * 获取jar包中的配置文件
     * @param classType
     * @return
     */
    public static InputStream loadResourceAsStream(Class<?> classType){
        String classPath = classType.getResource("").getPath();
        String jarPath = classPath.substring(0,classPath.indexOf("jar"));
        Enumeration<URL> urlEnumeration;
        try {
           urlEnumeration =  classType.getClassLoader().getResources(LOADPATH);
        } catch (IOException e) {
            logger.error("get resource urls failed!",e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
        }
        while(urlEnumeration.hasMoreElements()){
            URL url = urlEnumeration.nextElement();
            String resourcePath = url.getPath();
            String resourceJarPath = resourcePath.substring(0,resourcePath.indexOf("jar"));
            //同一个jar包中,则返回配置文件流
            if(jarPath.equals(resourceJarPath)){
                try {
                    return url.openConnection().getInputStream();
                } catch (IOException e) {
                    logger.error("open url failed ! url:[{}]",url.getPath());
                    logger.error("exception is ",e);
                    throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
                }
            }
        }
        logger.info("no resource found![{}]",classType.getName());
        return null;

    }
}
