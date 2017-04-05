package com.flyingrain.translate.framework.config;

import com.flyingrain.translate.framework.annotaions.Resource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
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

/**
 * Created by wally on 4/1/17.
 */
@Component
public class JerseyConfig extends ResourceConfig implements InitializingBean, ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Autowired
    @Qualifier("jerseyServlet")
    private ServletRegistrationBean servletRegistrationBean;

    public static List<Class> resources;

    @Override
    public void afterPropertiesSet() throws Exception {
        resources = new ArrayList<>();
        String names[] = applicationContext.getBeanNamesForAnnotation(Resource.class);
        for (String name :
                names) {
            resources.add(applicationContext.getBean(name).getClass());
        }

        servletRegistrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,MyApplication.class.getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
