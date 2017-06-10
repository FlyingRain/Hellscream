package com.flyingrain.translate.framework.api;

import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 6/10/17.
 */
@Configuration
public class ApiConfig {

    @Bean
    @Autowired
    TestResource testResource(RestWrapper restWrapper){
        return restWrapper.wrapper(TestResource.class);
    }

}
