package com.flyingrain.translate.framework.lang.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 18-4-2.
 *
 * @author wally
 */
public class JavaClassLoader {

    private static final String JAVASUFFIX = "class";

    private static Logger logger = LoggerFactory.getLogger(JavaClassLoader.class);

    /**
     * 装载包中的类
     * @param packagePath
     * @param classLoader
     * @return
     */
    public static Map<String, Class<?>> loadClasses(String packagePath, ClassLoader classLoader) {
        classLoader = classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
        String currentClassPath = JavaClassLoader.class.getResource("").getPath();
        logger.info("current classPath is :[{}]", currentClassPath);
        List<File> files = Stream.of(Objects.requireNonNull(Paths.get(currentClassPath, packagePath.replaceAll("\\.", "/")).toFile().listFiles(innerFile -> innerFile.getName().endsWith(JAVASUFFIX)))).collect(Collectors.toList());
        URLClassLoader urlClassLoader = new URLClassLoader(files.stream().map(FunctionWrapperUtil.wrapperUncheckedFunction(file -> file.toURI().toURL())).collect(Collectors.toList()).toArray(new URL[files.size()]), classLoader);
        Map<String, Optional<Class<?>>> optionalClasses = files.stream().map(FunctionWrapperUtil.wrapperUncheckedFunction(file -> urlClassLoader.loadClass(packagePath + "." + file.getName().substring(0, file.getName().length() - JAVASUFFIX.length() - 1)))).collect(Collectors.groupingBy(Class::getName, Collectors.mapping(l -> l, Collectors.reducing((l, r) -> l))));
        Map<String, Class<?>> classes = new HashMap<>();
        optionalClasses.forEach((k, v) -> classes.put(k, v.orElse(ObjectUtils.Null.class)));
        return classes;
    }


}
