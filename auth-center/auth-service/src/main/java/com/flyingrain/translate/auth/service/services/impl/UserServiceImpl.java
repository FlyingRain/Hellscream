package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.auth.service.services.UserService;
import com.flyingrain.translate.auth.service.services.dao.redis.intf.RUserDao;
import com.flyingrain.translate.user.api.UserResource;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户服务
 * Created by wally on 17-8-2.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserResource userResource;

    @Autowired
    private RUserDao rUserDao;


    @Override
    public LoginResponse login(AuthLoginRequest authLoginRequest) {
        LoginResult loginResult= userResource.login(transferLoginRequest(authLoginRequest));
        int userId = loginResult.getUserId();
        rUserDao.

        return null;
    }


    private LoginRequest transferLoginRequest(AuthLoginRequest authLoginRequest) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(authLoginRequest.getEmail());
        loginRequest.setPassword(authLoginRequest.getPassword());
        loginRequest.setPetName(authLoginRequest.getPetName());
        loginRequest.setPhone(authLoginRequest.getPhone());
        return loginRequest;
    }


    @Override
    public RegisterResponse register(AuthRegisterRequest registerRequest) {
        return null;
    }
}
