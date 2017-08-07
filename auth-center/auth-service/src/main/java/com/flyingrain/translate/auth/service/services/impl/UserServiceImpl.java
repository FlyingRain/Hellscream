package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.auth.service.services.UserService;
import com.flyingrain.translate.auth.service.services.config.AuthConfig;
import com.flyingrain.translate.auth.service.services.dao.redis.intf.RUserDao;
import com.flyingrain.translate.user.api.UserResource;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 用户服务
 * Created by wally on 17-8-2.
 */
@Component
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AuthConfig authConfig;
    @Autowired
    private UserResource userResource;

    @Autowired
    private RUserDao rUserDao;


    @Override
    public LoginResponse login(AuthLoginRequest authLoginRequest) {
        LoginResult loginResult= userResource.login(transferLoginRequest(authLoginRequest));
        int userId = loginResult.getUserId();
        logger.info("start to del cache,userId:[{}]",userId);
        rUserDao.delToken(null,String.valueOf(userId));
        //get token
        String token = UUID.randomUUID().toString();
        logger.info("start to cache the login status ! userId:[{}]",userId);
        rUserDao.insertUserToken(String.valueOf(userId),token,authConfig.getExpireDay());
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUserId(String.valueOf(userId));
        return response;
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
        logger.info("start to userCenter to register!");
        String userId = userResource.addUser(getUserInfo(registerRequest));
        logger.info("register success! userId :[{}]",userId);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserId(userId);
        return registerResponse;
    }

    @Override
    public String logoff(String userId) {
        rUserDao.delToken(null,userId);
        return "success";
    }

    private UserInfo getUserInfo(AuthRegisterRequest registerRequest){
        UserInfo userInfo  = new UserInfo();
        BeanUtils.copyProperties(registerRequest,userInfo);
        return userInfo;
    }
}
