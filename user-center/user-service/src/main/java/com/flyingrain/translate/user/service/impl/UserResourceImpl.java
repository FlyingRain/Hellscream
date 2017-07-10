package com.flyingrain.translate.user.service.impl;

import com.flyingrain.translate.user.api.UserResource;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.api.response.UserInfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-4.
 */
@Component
public class UserResourceImpl implements UserResource{

    private Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

    @Override
    public String addUser(UserInfo userInfo) {


        return null;
    }

    @Override
    public UserInfoResult getUserInfo(int userId) {
        return null;
    }

    @Override
    public LoginResult login(LoginRequest loginRequest) {
        return null;
    }
}
