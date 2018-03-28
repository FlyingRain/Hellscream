package com.flyingrain.translate.dungeon.api.conf;


import com.flyingrain.translate.dungeon.api.DungeonResources;
import com.flyingrain.translate.framework.wrapper.impl.RestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 8/16/17.
 */
@Configuration
public class DungeonApiConfig {

    @Bean
    @Autowired
    DungeonResources dungeonResources(RestWrapper restWrapper){
        return restWrapper.wrapper(DungeonResources.class);
    }

}
