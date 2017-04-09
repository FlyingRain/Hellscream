package com.flyingrain.translate.database.conf;

import com.flyingrain.translate.database.conf.databases.DataBasePro;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据库基础配置
 *
 * Created by wally on 4/7/17.
 */
@Configuration
//@PropertySource("classpath:myconf.properties")
@EnableConfigurationProperties(DataBasePro.class)
@Import(DynamicDataSourceRegister.class)
public class BaseConfig {


}
