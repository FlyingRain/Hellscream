package com.flyingrain.translate.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/8/17.
 */
@ConfigurationProperties(prefix = "load")
public class PropertiesContext {

    private List<String> properties = new ArrayList<>();

    private List<String> yamls = new ArrayList<>();

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getYamls() {
        return yamls;
    }

    public void setYamls(List<String> yamls) {
        this.yamls = yamls;
    }
}
