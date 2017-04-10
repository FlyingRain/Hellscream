package com.flyingrain.translate.words.collection.service.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 4/10/17.
 */
@Configuration
@MapperScan("com.flyingrain.translate.words.collection.service.dao.mapper")
public class Config {
}
