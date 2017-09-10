package com.flyingrain.translate.dungeon.service.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 副本服务配置
 * Created by wally on 17-9-10.
 */
@Configuration
@MapperScan("com.flyingrain.translate.dungeon.service.services.dao.mapper")
public class DungeonServiceConfig {
}
