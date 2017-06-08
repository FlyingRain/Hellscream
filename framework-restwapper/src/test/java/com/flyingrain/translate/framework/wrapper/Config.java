package com.flyingrain.translate.framework.wrapper;

import com.flyingrain.translate.framework.api.TestResource;
import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wally on 6/8/17.
 */
@TestConfiguration
@ComponentScan(basePackages = "com.flyingrain.translate")
@EnableAutoConfiguration
public class Config {

    @Bean
    @Autowired
    TestResource testResource(RestWrapper restWrapper){
        return restWrapper.wrapper(TestResource.class);
    }

}
