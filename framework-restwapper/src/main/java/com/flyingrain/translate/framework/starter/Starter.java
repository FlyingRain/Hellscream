package com.flyingrain.translate.framework.starter;

import com.flyingrain.translate.framework.config.AppConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by wally on 4/1/17.
 */
public class Starter {

    public static void  run (String[] args) {
        new SpringApplicationBuilder().sources(AppConfig.class).run(args);
    }


}
