package com.flyingrain.translate.framework.starter;

import com.flyingrain.translate.framework.config.AppConfig;
import com.flyingrain.translate.framework.config.LoadAdditionalProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by wally on 4/1/17.
 */
public class Starter {

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(AppConfig.class).listeners(new LoadAdditionalProperty()).run(args);
    }


}
