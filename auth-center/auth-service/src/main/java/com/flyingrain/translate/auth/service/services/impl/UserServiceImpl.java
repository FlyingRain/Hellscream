package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.auth.service.services.UserService;
import com.flyingrain.translate.user.api.UserResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户服务
 * Created by wally on 17-8-2.
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserResource userResource;

    @Override
    public LoginResponse login(AuthLoginRequest authLoginRequest) {
        return null;
    }

    @Override
    public RegisterResponse register(AuthRegisterRequest registerRequest) {
        return null;
    }
}
