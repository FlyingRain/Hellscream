package com.flyingrain.translate.user.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.user.api.UserResource;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.request.WxBindRequest;
import com.flyingrain.translate.user.api.request.WxLoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.api.response.UserInfoResult;
import com.flyingrain.translate.user.service.services.UserAuthorityService;
import com.flyingrain.translate.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-4.
 */
@Component
@Resource
public class UserResourceImpl implements UserResource {

    private Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthorityService authorityService;

    @Override
    public String addUser(UserInfo userInfo) {
        logger.info("start to add user,petName is [{}]", userInfo.getPetName());
        int userId = userService.insertUserInfo(userInfo);
        logger.info("return userId :[{}]", userId);
        return String.valueOf(userId);
    }

    @Override
    public UserInfoResult getUserInfo(int userId) {
        logger.info("start to get userInfo by userId:[{}]", userId);
        return userService.getUserInfoById(userId);
    }

    @Override
    public LoginResult login(LoginRequest loginRequest) {
        logger.info("receive login request : [{}]", loginRequest);
        return authorityService.userLogin(loginRequest);
    }

    @Override
    public LoginResult wxLogin(WxLoginRequest wxLoginRequest) {
        logger.info("wxLogin request:[{}]", wxLoginRequest);
        return authorityService.wxLogin(wxLoginRequest);
    }

    @Override
    public boolean bindWx(WxBindRequest wxBindRequest) {
        logger.info("wxBindRequest :[{}]", wxBindRequest);
        return authorityService.wxBind(wxBindRequest);
    }


}
