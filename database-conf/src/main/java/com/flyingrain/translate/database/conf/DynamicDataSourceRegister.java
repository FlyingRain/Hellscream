package com.flyingrain.translate.database.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wally on 4/9/17.
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);


    public DynamicDataSourceRegister() {
    }


    private DataSource defaultDataSource;

    private Map<String, DataSource> otherDataSources;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        if(defaultDataSource==null){
            logger.error("no default datasource to be used ! please specify a default datasource.");
            throw new RuntimeException("no default datasource to be used!");
        }
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", otherDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }

    @Override
    public void setEnvironment(Environment environment) {
        init(environment);


    }


    private void init(Environment environment) {
        int i = 0;
        otherDataSources = new HashMap<>();
        while (true) {
            DataMap dataSourceMap = getDataSource(environment, "datasource.config[" + i + "]");
            if (dataSourceMap == null) {
                break;
            }
            i++;
            if ("wrong".equals(dataSourceMap.getName())) {
                continue;
            }
            if ("default".equals(dataSourceMap.getName())) {
                if (defaultDataSource == null) {
                    defaultDataSource = dataSourceMap.getDataSource();
                    logger.info("load default datasource: " + dataSourceMap.getName());
                    continue;
                }else{
                    logger.warn("duplicated default dataSource!" + dataSourceMap.getName());
                    continue;
                }
            }
            otherDataSources.put(dataSourceMap.getName(), dataSourceMap.getDataSource());
            DataBaseContextHolder.dataSourceList.add(dataSourceMap.getName());
            logger.info("load datasource :" + dataSourceMap.getName());

        }


    }


    private DataMap getDataSource(Environment environment, String prefix) {
        DataMap dataMap = new DataMap();
        String sourceName = environment.getProperty(prefix + ".sourceName");
        String userName = environment.getProperty(prefix + ".userName");
        String driveClass = environment.getProperty(prefix + ".driveClass");
        String url = environment.getProperty(prefix + ".url");
        String password = environment.getProperty(prefix + ".password");
        if (StringUtils.isEmpty(url) && StringUtils.isEmpty(userName) && StringUtils.isEmpty(driveClass) && StringUtils.isEmpty(password)) {
            return null;
        }
        //如果参数为空则返回null
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(driveClass) || StringUtils.isEmpty(password)) {
            logger.error("dataSource config is wrong!");
            dataMap.setName("wrong");
            dataMap.setDataSource(null);
            return dataMap;
        }

        if (StringUtils.isEmpty(sourceName)) {
            sourceName = "default";
        }

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driveClass);
        dataSource.setPassword(password);

        //数据库链接池配置
        //最小空闲链接
        dataSource.setMinIdle(Integer.parseInt(environment.getProperty("datasource.pool.minIdle")));
        dataSource.setMaxIdle(Integer.parseInt(environment.getProperty("datasource.pool.maxIdle")));
        dataSource.setMaxWaitMillis(Integer.parseInt(environment.getProperty("datasource.pool.maxWait")));
        dataSource.setMaxOpenPreparedStatements(Integer.parseInt(environment.getProperty("datasource.pool.maxActive")));
        dataSource.setInitialSize(Integer.parseInt(environment.getProperty("datasource.pool.initialSize")));
        dataSource.setRemoveAbandonedTimeout(Integer.parseInt(environment.getProperty("datasource.pool.removeAbandonedTimeout")));
        dataSource.setRemoveAbandonedOnBorrow(Boolean.parseBoolean(environment.getProperty("datasource.pool.removeAbandoned")));


        dataMap.setName(sourceName);
        dataMap.setDataSource(dataSource);
//        dataSourceMap.put(sourceName, dataSource);
        return dataMap;

    }

    class DataMap {
        String name;
        DataSource dataSource;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public DataSource getDataSource() {
            return dataSource;
        }

        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
        }
    }
}
