package com.flyingrain.translate.database.conf.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by wally on 4/7/17.
 */
public class ApplicationInitialize  implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private Logger logger = LoggerFactory.getLogger(ApplicationInitialize.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try{
            Resource resource = applicationContext.getResource("file:myconf.yml");
            YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
            PropertySource<?> yamlPropertySource = loader.load("myconf",resource,null);
            applicationContext.getEnvironment().getPropertySources().addFirst(yamlPropertySource);
        }catch (IOException e){
            logger.error("load yaml property failed!",e);
        }
    }
}
