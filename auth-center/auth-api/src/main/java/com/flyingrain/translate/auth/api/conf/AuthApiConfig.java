package com.flyingrain.translate.auth.api.conf;

import com.flyingrain.translate.auth.api.AuthResource;
import com.flyingrain.translate.auth.api.UserAuthResource;
import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 17-7-20.
 */

@Configuration
public class AuthApiConfig {

    @Bean
    @Autowired
    AuthResource getAuthResource(RestWrapper wrapper){
        return wrapper.wrapper(AuthResource.class);
    }

    @Bean
    @Autowired
    UserAuthResource getUserResource(RestWrapper wrapper){
        return wrapper.wrapper(UserAuthResource.class);
    }

}
