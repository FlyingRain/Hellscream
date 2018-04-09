package com.flyingrain.translate.framework.lang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 18-4-2.
 *
 * @author wally
 */
public class JavaClassLoader {

    private static final String JAVASUFFIX = "class";

    private static final String JARTAG = ".jar!";

    private static Logger logger = LoggerFactory.getLogger(JavaClassLoader.class);

    /**
     * 装载包中的类(包含jar包中的)
     *
     * @param packagePath
     * @param classLoader
     * @return
     */
    public static List<Class<?>> loadClasses(String packagePath, ClassLoader classLoader) throws IOException, URISyntaxException {
        classLoader = classLoader == null ? Thread.currentThread().getContextClassLoader() : classLoader;
        Enumeration<URL> urlEnumeration = classLoader.getResources(packagePath.replaceAll("\\.", "/"));
        List<String> classes = new ArrayList<>();
        List<URL> urls = new ArrayList<>();
        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();
            urls.add(url);
            classes.addAll(url.getPath().contains(JARTAG) ? loadJarClass(url) : loadPackageClassFile(url, packagePath));
        }

        String currentClassPath = JavaClassLoader.class.getResource("").getPath();
        logger.info("current classPath is :[{}]", currentClassPath);
//        URLClassLoader urlClassLoader = new URLClassLoader(urls.toArray(new URL[0]), classLoader);
        return classes.stream().map(FunctionWrapperUtil.wrapperUncheckedFunction(classLoader::loadClass)).collect(Collectors.toList());
    }


    private static List<String> loadPackageClassFile(URL url, String packagePath) throws URISyntaxException {
        File file = new File(url.toURI());
        File[] files = file.listFiles(innerFile -> innerFile.getName().endsWith(JAVASUFFIX));
        if (files == null || files.length == 0) {
            logger.info("there is no class file!");
            return new ArrayList<>();
        }
        return Stream.of(files).map(innerFile -> packagePath + innerFile.getName().substring(0, JAVASUFFIX.length() - 1)).collect(Collectors.toList());
    }

    private static List<String> loadJarClass(URL url) throws IOException {
        List<String> jarClasses = new ArrayList<>();
        String jarPath = url.getPath().substring(5, url.getPath().indexOf(".jar") + 4);
        JarFile jarFile = new JarFile(jarPath);
        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
        while (jarEntryEnumeration.hasMoreElements()) {
            JarEntry jarEntry = jarEntryEnumeration.nextElement();
            if (jarEntry.getName().endsWith(JAVASUFFIX))
                jarClasses.add(jarEntry.getName().substring(0,jarEntry.getName().length()-JAVASUFFIX.length()-1).replaceAll("/","."));
        }
        return jarClasses;
    }

}
