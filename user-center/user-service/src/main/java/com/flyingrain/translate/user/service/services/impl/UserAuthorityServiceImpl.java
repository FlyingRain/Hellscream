package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.user.api.request.AuthRequest;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.service.services.UserAuthorityService;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-11.
 */
@Component
public class UserAuthorityServiceImpl implements UserAuthorityService{

    @Override
    public LoginResult userLogin(LoginRequest request) {
        return null;
    }

    @Override
    public boolean authRequest(AuthRequest authRequest) {
        return false;
    }
}
