package com.flyingrain.translate.plan.service.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 4/25/17.
 */
@Configuration
@MapperScan("com.flyingrain.translate.plan.service.services.dao.mapper")
public class Config {
}
