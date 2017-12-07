package com.flyingrain.translate.auth.service.services.dao.redis.impl;

import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.dao.redis.intf.RUserDao;
import com.flyingrain.translate.framework.lang.FlyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
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
    /**
     * 键的分隔符
     */
    private static final String SPLIT = "_";

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String,String> valueOperations;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String getUserId(String token) {
        String key = LOGINKEY + SPLIT + "*" + SPLIT + token;
        Set<String> result = stringRedisTemplate.keys(key);
        if (result == null || result.size() != 1) {
            logger.info("get cache failed!token: [{}]", token);
            throw new FlyException(AuthError.LOGINEXPIRE.getCode(), AuthError.LOGINEXPIRE.getMsg());
        }
        String realKey = (String) result.toArray()[0];
        return valueOperations.get(realKey);
    }

    @Override
    public boolean insertUserToken(String userId, String token, int expiryTime) {
        logger.info("start insert redis userId:[{}]", userId);

        String key = LOGINKEY + SPLIT + userId + SPLIT + token;
        if (valueOperations.setIfAbsent(key, userId)) {
            stringRedisTemplate.expire(token, expiryTime, TimeUnit.DAYS);
            return true;
        }
        return false;
    }

    @Override
    public void delToken(String token, String userId) {
        logger.info("start to delete token :[{}]", token);
        String keyPattern = StringUtils.isEmpty(token) ? (LOGINKEY + SPLIT + userId + SPLIT + "*") : (LOGINKEY + SPLIT + "*" + SPLIT + token);
        Set<String> result = stringRedisTemplate.keys(keyPattern);
        result.forEach(key -> stringRedisTemplate.delete(key));
    }
}
