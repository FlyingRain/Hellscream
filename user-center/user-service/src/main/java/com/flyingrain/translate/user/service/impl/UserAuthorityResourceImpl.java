package com.flyingrain.translate.user.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.user.api.UserAuthorityResource;
import com.flyingrain.translate.user.api.request.UserAuthRequest;
import com.flyingrain.translate.user.service.services.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-10.
 */
@Component
@Resource
public class UserAuthorityResourceImpl implements UserAuthorityResource{

    @Autowired
    private UserAuthorityService userAuthorityService;

    @Override
    public boolean auth(UserAuthRequest request) {
        return userAuthorityService.authRequest(request);
    }
}
