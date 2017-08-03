package com.flyingrain.translate.auth.service.services.dao.redis.impl;

import com.flyingrain.translate.auth.service.services.dao.redis.intf.RUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by wally on 17-7-30.
 */
@Component
public class RUserDaoImpl implements RUserDao {

    private Logger logger = LoggerFactory.getLogger(RUserDaoImpl.class);

    /**
     * 用于缓存用户的key
     */
    private static final String LOGINKEY = "login";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String,String> hashOperations;

    private StringRedisTemplate redisTemplate;

    @Override
    public String getUserId(String token) {
        return hashOperations.get(LOGINKEY,token);
    }

    @Override
    public boolean insertUserToken(String userId, String token, int expiryTime) {
        logger.info("start insert redis userId:[{}]", userId);

        if (hashOperations.putIfAbsent(LOGINKEY,token,userId)) {
            redisTemplate.expire(token, expiryTime, TimeUnit.DAYS);
            return true;
        }
        return false;
    }

    @Override
    public void delToken(String token) {
        logger.info("start to delete token :[{}]", token);
        redisTemplate.delete(token);
    }
}
