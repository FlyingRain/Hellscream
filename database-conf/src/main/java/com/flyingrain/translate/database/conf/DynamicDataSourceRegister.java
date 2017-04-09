package com.flyingrain.translate.database.conf;

import com.flyingrain.translate.database.conf.databases.DataBasePro;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private DataBasePro dataBasePro;

    public DynamicDataSourceRegister() {
    }


    private DataSource defaultDataSource;

    private Map<String, DataSource> otherDataSources;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
    }

    @Override
    public void setEnvironment(Environment environment) {
        init(environment);


    }

    private Map<String, DataSource> getOtherDataSources(Environment environment) {

        Map<String, DataSource> otherDatasources = new HashMap<>();


    }

    private void init(Environment environment) {
        int i = 0;
        while (true) {
            Map<String, DataSource> dataSourceMap = getDataSource(environment, "datasource.config[" + i + "]");
            if (dataSourceMap==null){
                break;
            }
        
                i++;
        }


    }


    private Map<String, DataSource> getDataSource(Environment environment, String prefix) {

        Map<String, DataSource> dataSourceMap = new HashMap<>();
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
            dataSourceMap.put("wrong",null);
            return dataSourceMap;
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

        dataSourceMap.put(sourceName, dataSource);
        return dataSourceMap;

    }
}
