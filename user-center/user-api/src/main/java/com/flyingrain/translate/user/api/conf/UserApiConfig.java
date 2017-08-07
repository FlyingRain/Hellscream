package com.flyingrain.translate.user.api.conf;

import com.flyingrain.translate.framework.wrapper.Wrapper;
import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import com.flyingrain.translate.user.api.UserAuthorityResource;
import com.flyingrain.translate.user.api.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 6/29/17.
 */
@Configuration
public class UserApiConfig {

    @Bean
    @Autowired
    UserAuthorityResource userAuthorityResource(RestWrapper wrapper){
        return wrapper.wrapper(UserAuthorityResource.class);
    }

    @Bean
    @Autowired
    UserResource userResource(RestWrapper wrapper){
        return wrapper.wrapper(UserResource.class);
    }

}
