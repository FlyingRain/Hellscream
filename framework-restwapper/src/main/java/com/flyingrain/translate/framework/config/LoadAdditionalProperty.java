package com.flyingrain.translate.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 装载自定义的配置文件
 * Created by wally on 4/8/17.
 */
public class LoadAdditionalProperty implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

    private Logger logger = LoggerFactory.getLogger(LoadAdditionalProperty.class);

    private ResourceLoader loader = new DefaultResourceLoader();

    private YamlPropertySourceLoader yamlLoader = new YamlPropertySourceLoader();

    private PropertySourcesLoader propertyLoader = new PropertySourcesLoader();

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        List<String> propertiesFilePaths = new ArrayList<>();

        List<String> yamlFilePaths = new ArrayList<>();
        int i = 0;
        while(true){
            String propertyFilePath = environment.getProperty("load.properties["+i+"]");
            if(propertyFilePath==null){
                break;
            }
            i++;
            if("".equals(propertyFilePath)){
                continue;
            }
            propertiesFilePaths.add(propertyFilePath);

        }
        i=0;
        while(true){

            String yamlFilePath = environment.getProperty("load.yaml["+i+"]");
            if(yamlFilePath==null){
                break;
            }
            i++;
            if("".equals(yamlFilePath)){
                continue;
            }
            yamlFilePaths.add(yamlFilePath);

        }

        propertiesFilePaths.forEach(filePath->{
            try {
                environment.getPropertySources().addLast(propertyLoader.load(loader.getResource(filePath)));
            } catch (IOException e) {
                logger.error("load property file failed!file:" + filePath);
                throw new RuntimeException(e);
            }
        });

        yamlFilePaths.forEach(filePath->{

            try {
                environment.getPropertySources().addLast(yamlLoader.load(filePath,loader.getResource(filePath),null));
            } catch (IOException e) {
                logger.error("load property file failed!file:" + filePath);
                throw new RuntimeException(e);
            }

        });



    }
}
