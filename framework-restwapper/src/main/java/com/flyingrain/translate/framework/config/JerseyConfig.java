package com.flyingrain.translate.framework.config;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.exceptionHandler.AppExceptionHandler;
import com.flyingrain.translate.framework.filter.RequestFilter;
import com.flyingrain.translate.framework.filter.ResponseFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wally on 4/1/17.
 */
@Component
public class JerseyConfig extends ResourceConfig implements InitializingBean, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(JerseyConfig.class);
    private static ApplicationContext applicationContext;
    @Autowired
    @Qualifier("jerseyServlet")
    private ServletRegistrationBean servletRegistrationBean;

    public static List<Class> resources;

    @Override
    public void afterPropertiesSet() throws Exception {
        resources = new ArrayList<>();
        String names[] = applicationContext.getBeanNamesForAnnotation(Resource.class);
        resources = Stream.of(names)
                .map(name->applicationContext.getBean(name).getClass())
                .collect(Collectors.toList());
        resources.add(AppExceptionHandler.class);
        resources.add(RequestFilter.class);
        resources.add(ResponseFilter.class);
        resources.add(MultiPartFeature.class);
        servletRegistrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,MyApplication.class.getName());

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
