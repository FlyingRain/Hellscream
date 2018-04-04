package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created on 4/4/18.
 *
 * @author wally
 */
public class JavaClassLoaderTest {


    @Test
    public void testLoadClass(){
        String testPackage = "org.apache.commons.lang3";
        try {
            List<Class<?>> classes = JavaClassLoader.loadClasses(testPackage,Thread.currentThread().getContextClassLoader());
            classes.forEach(System.out::println);
        } catch (IOException |URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
