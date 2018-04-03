package com.flyingrain.translate.framework.lang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created on 18-4-2.
 *
 * @author wally
 */
public class JavaClassLoader {

    private static final String JAVASUFFIX = "class";

    private static Logger logger = LoggerFactory.getLogger(JavaClassLoader.class);

    public static Map<String, Class<?>> loadClasses(String packagePath, ClassLoader classLoader) {

        classLoader = classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
        String currentClassPath = JavaClassLoader.class.getResource("").getPath();
        logger.info("current classPath is :[{}]", currentClassPath);
        List<File> files = Arrays.asList(Paths.get(currentClassPath, packagePath.replaceAll("\\.", "/")).toFile().listFiles(innerFile->{
           return innerFile.getName().endsWith(JAVASUFFIX);
        }));


    }
}
