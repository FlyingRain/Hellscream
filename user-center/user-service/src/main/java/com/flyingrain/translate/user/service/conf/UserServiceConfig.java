package com.flyingrain.translate.user.service.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wally on 17-7-4.
 */
@Configuration
@MapperScan("com.flyingrain.translate.user.service.services.dao.mapper")
public class UserServiceConfig {


}
