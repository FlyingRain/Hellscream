package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.api.request.UserAuthRequest;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.service.services.UserAuthorityService;
import com.flyingrain.translate.user.service.services.common.UserCenterExceptionEnum;
import com.flyingrain.translate.user.service.services.dao.mapper.RoleAuthorityMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserInfoMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserLoginMapper;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import com.flyingrain.translate.user.service.services.dao.model.UserLoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-11.
 */
@Component
public class UserAuthorityServiceImpl implements UserAuthorityService{


    private Logger logger = LoggerFactory.getLogger(UserAuthorityServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserLoginMapper loginMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Override
    public LoginResult userLogin(LoginRequest request) {
        logger.info("login user : [{}]",request);
        int userId = userInfoMapper.getUserId(transferRequest(request));
        logger.info("get userId :[{}]",userId);
        UserLoginModel loginModel = new UserLoginModel();
        loginModel.setPassword(request.getPassword());
        loginModel.setUser_id(userId);
        int i = loginMapper.authentity(loginModel);
        logger.info("login result :[{}]",i);
        if(i!=1){
            throw new FlyException(UserCenterExceptionEnum.LoginFailure.getCode(),UserCenterExceptionEnum.LoginFailure.getMsg());
        }
        LoginResult result = new LoginResult();
        result.setUserId(userId);
        return result;
    }

    private UserInfoModel transferRequest(LoginRequest request){
        UserInfoModel model = new UserInfoModel();
        model.setEmail(request.getEmail());
        model.setPhone(request.getPhone());
        model.setPet_name(request.getPetName());
        return model;
    }

    @Override
    public boolean authRequest(UserAuthRequest authRequest) {
        return roleAuthorityMapper.getAuthority(authRequest.getUserId(),authRequest.getUrl())!=null;
    }
}
