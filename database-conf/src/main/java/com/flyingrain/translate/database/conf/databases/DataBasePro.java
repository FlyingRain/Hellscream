package com.flyingrain.translate.database.conf.databases;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/7/17.
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DataBasePro {

   private List<Config> config = new ArrayList<>();

    public List<Config> getConfig() {
        return config;
    }

    public void setConfig(List<Config> config) {
        this.config = config;
    }
}
