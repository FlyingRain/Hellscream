package com.flyingrain.translate.database.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.database.conf.databases.RedisConf;
import com.flyingrain.translate.database.conf.databases.RedisPoolConf;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis相关配置
 * Created by wally on 7/26/17.
 */
@Configuration
@EnableConfigurationProperties({RedisConf.class, RedisPoolConf.class})
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private Environment environment;


    @Bean
    @Autowired
    public JedisPoolConfig getPoolConfig(RedisPoolConf redisPoolConf) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPoolConf.getMaxIdle());
        poolConfig.setMaxTotal(redisPoolConf.getMaxActive());
        poolConfig.setMinIdle(redisPoolConf.getMinIdle());
        poolConfig.setMaxWaitMillis(redisPoolConf.getMaxWait());
        return poolConfig;
    }

    @Bean
    @Autowired
    public JedisConnectionFactory getConnectionFactory(RedisConf redisConf, JedisPoolConfig poolConfig) {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
        if (StringUtils.isNotEmpty(redisConf.getHost())) {
            connectionFactory.setHostName(redisConf.getHost());
        }
        if (redisConf.getDatabase() > 0) {
            connectionFactory.setDatabase(redisConf.getDatabase());
        }
        if (StringUtils.isNotEmpty(redisConf.getPassword())) {
            connectionFactory.setPassword(redisConf.getPassword());
        }
        if (redisConf.getPort()!=null) {
            connectionFactory.setPort(redisConf.getPort());
        }
        if (redisConf.getTimeout()!=null) {
            connectionFactory.setTimeout(redisConf.getTimeout());
        }
        logger.info("success to load JedisConnectionFactory!");
        return connectionFactory;
    }

    @Bean
    @Autowired
    public RedisTemplate<String, String> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(jedisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        //设置jackson如何序列化
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        //设置序列话工具（默认是二进制）
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}

