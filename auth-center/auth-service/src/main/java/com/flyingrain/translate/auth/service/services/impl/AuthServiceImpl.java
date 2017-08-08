package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.AuthRequest;
import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.AuthService;
import com.flyingrain.translate.auth.service.services.config.AuthConfig;
import com.flyingrain.translate.auth.service.services.dao.redis.intf.RAuthorityDao;
import com.flyingrain.translate.auth.service.services.dao.redis.intf.RUserDao;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.api.UserAuthorityResource;
import com.flyingrain.translate.user.api.request.UserAuthRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 8/3/17.
 */
@Component
public class AuthServiceImpl implements AuthService {

    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserAuthorityResource userAuthorityResource;

    @Autowired
    private RAuthorityDao authorityDao;

    @Autowired
    private RUserDao userDao;

    @Autowired
    private AuthConfig authConfig;

    @Override
    public boolean authority(AuthRequest request) {
        String userId = userDao.getUserId(request.getToken());
        if (StringUtils.isEmpty(userId)) {
            logger.info("user login expired token:[{}]", request.getToken());
            throw new FlyException(AuthError.LOGINEXPIRE.getCode(), AuthError.LOGINEXPIRE.getMsg());
        }
        int i = authorityDao.getAuth(userId, request.getUrl());
        if (i == 1) {
            return true;
        } else {
            logger.info("the user has no auth cached in redis, start to userCenter.userId :[{}]", userId);
            UserAuthRequest authRequest = new UserAuthRequest();
            authRequest.setUserId(Integer.parseInt(userId));
            authRequest.setUrl(request.getUrl());
            if (userAuthorityResource.auth(authRequest)) {
                logger.info("start cache authResult!");
                int m = authorityDao.insertAuth(userId, request.getUrl(), authConfig.getExpireMinute());
                if (m != 1) {
                    logger.error("cache failed!");
                }
                return true;
            }
        }

        return false;
    }
}
