package com.flyingrain.translate.database.conf;

import com.flyingrain.translate.database.conf.databases.DataBasePro;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 数据库基础配置
 * <p>
 * Created by wally on 4/7/17.
 */
@Configuration
@PropertySource({"classpath:datasource.properties","classpath:redispool.properties"})
@EnableConfigurationProperties(DataBasePro.class)
@Import(DynamicDataSourceRegister.class)
@MapperScan("com.flyingrain.translate.database.conf.test.data.mapper")
public class BaseConfig {


    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactory(DynamicDataSource dynamicDataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dynamicDataSource);
        //DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        //sqlSessionFactory.setMapperLocations(new Resource[]{resourceLoader.getResource("classpath:mapper/*.xml")});
        return sqlSessionFactory;
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager transactionManager(DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }

}
