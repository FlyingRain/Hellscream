package com.flyingrain.translate.framework.config;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * Created by wally on 4/1/17.
 */
@Configuration
@ComponentScan(basePackages = "com.flyingrain.translate")
@PropertySource("classpath:token.properties")
@EnableAspectJAutoProxy
@EnableAutoConfiguration
//@EnableConfigurationProperties(PropertiesContext.class)
public class AppConfig {

    @Autowired
    private Environment environment;
    @Bean
    public ServletRegistrationBean jerseyServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new ServletContainer(),(environment.getProperty("serverPrefix")==null?"":environment.getProperty("serverPrefix"))+"/*");
        return registrationBean;
    }


    @Bean
    public JettyEmbeddedServletContainerFactory servletContainerFactory(){
        JettyEmbeddedServletContainerFactory servletContainerFactory = new JettyEmbeddedServletContainerFactory();
        return servletContainerFactory;
    }


}
