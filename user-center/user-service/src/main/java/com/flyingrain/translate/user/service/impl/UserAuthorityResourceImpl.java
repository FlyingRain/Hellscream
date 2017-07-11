package com.flyingrain.translate.user.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.user.api.UserAuthorityResource;
import com.flyingrain.translate.user.api.request.AuthRequest;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-10.
 */
@Component
@Resource
public class UserAuthorityResourceImpl implements UserAuthorityResource{

    @Override
    public boolean auth(AuthRequest request) {
        return false;
    }
}
