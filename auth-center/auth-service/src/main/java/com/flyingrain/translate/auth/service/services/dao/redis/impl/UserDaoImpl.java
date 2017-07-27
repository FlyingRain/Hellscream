package com.flyingrain.translate.auth.service.services.dao.redis.impl;

import com.flyingrain.translate.auth.service.services.dao.redis.interfaces.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by wally on 17-7-27.
 */
@Component
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    private StringRedisTemplate redisTemplate;

    @Override
    public String getUserId(String token) {
        return valueOperations.get(token);
    }

    @Override
    public void insertUserToken(String userId, String token, int expiryTime) {
        logger.info("start insert redis userId:[{}]", userId);
        valueOperations.set(token, userId, expiryTime, TimeUnit.DAYS);
    }

    @Override
    public void delToken(String token) {
        redisTemplate.delete(token);
    }
}
