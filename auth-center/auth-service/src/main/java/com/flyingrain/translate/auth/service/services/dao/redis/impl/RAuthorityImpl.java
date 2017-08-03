package com.flyingrain.translate.auth.service.services.dao.redis.impl;

import com.flyingrain.translate.auth.service.services.dao.redis.intf.RAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by wally on 17-8-2.
 */
@Component
public class RAuthorityImpl implements RAuthority {

    private Logger logger = LoggerFactory.getLogger(RAuthorityImpl.class);

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOperations;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public int insertAuth(String userId, String url, int expiryMinute) {
        Long i = setOperations.add(userId, url);
        boolean expire = redisTemplate.expire(userId, expiryMinute, TimeUnit.MINUTES);
        if (expire) {
            logger.error("set key expire time failed! userId is [{}]", userId);
        }
        return i.intValue();
    }

    @Override
    public int getAuth(String userId, String url) {
        return setOperations.isMember(userId, url) ? 1 : 0;
    }
}
