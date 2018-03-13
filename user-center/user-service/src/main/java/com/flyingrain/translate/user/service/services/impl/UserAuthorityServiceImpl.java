package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.auth.api.VerifyResource;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.api.request.UserAuthRequest;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.request.WxBindRequest;
import com.flyingrain.translate.user.api.request.WxLoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;
import com.flyingrain.translate.user.service.services.UserAuthorityService;
import com.flyingrain.translate.user.service.services.common.UserCenterExceptionEnum;
import com.flyingrain.translate.user.service.services.dao.mapper.RoleAuthorityMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserInfoMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserLoginMapper;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import com.flyingrain.translate.user.service.services.dao.model.UserLoginModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-11.
 */
@Component
public class UserAuthorityServiceImpl implements UserAuthorityService {


    private Logger logger = LoggerFactory.getLogger(UserAuthorityServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserLoginMapper loginMapper;

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Autowired
    private VerifyResource verifyResource;

    @Override
    public LoginResult userLogin(LoginRequest request) {
        logger.info("login user : [{}]", request);
        int userId = userInfoMapper.getUserId(transferRequest(request));
        logger.info("get userId :[{}]", userId);
        UserLoginModel loginModel = loginMapper.authentity(userId);
        if (loginModel == null) {
            throw new FlyException(UserCenterExceptionEnum.USERNOTEXIT.getCode(), UserCenterExceptionEnum.USERNOTEXIT.getMsg());
        }
        String pass = verifyResource.decrypt(request.getPassword());
        if (!pass.equals(verifyResource.decrypt(loginModel.getPassword()))) {
            throw new FlyException(UserCenterExceptionEnum.LoginFailure.getCode(), UserCenterExceptionEnum.LoginFailure.getMsg());
        }
        LoginResult result = new LoginResult();
        result.setUserId(userId);
        return result;
    }

    private UserInfoModel transferRequest(LoginRequest request) {
        UserInfoModel model = new UserInfoModel();
        model.setEmail(request.getEmail());
        model.setPhone(request.getPhone());
        model.setPet_name(request.getPetName());
        return model;
    }

    @Override
    public boolean authRequest(UserAuthRequest authRequest) {
        if (!StringUtils.isEmpty(authRequest.getWeixin())) {
            UserInfoModel userInfoModel = new UserInfoModel();
            userInfoModel.setWeixin(authRequest.getWeixin());
            int userId = userInfoMapper.getUserId(userInfoModel);
            authRequest.setUserId(userId);
        }
        return roleAuthorityMapper.getAuthority(authRequest.getUserId(), authRequest.getUrl()) != null;
    }

    @Override
    public LoginResult wxLogin(WxLoginRequest request) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setWeixin(request.getWxNo());
        int userId = userInfoMapper.getUserId(userInfoModel);
        logger.info("get userId:[{}]", userId);
        if (userId == 0) {
            return null;
        }
        LoginResult result = new LoginResult();
        result.setUserId(userId);
        return result;
    }

    @Override
    public boolean wxBind(WxBindRequest bindRequest) {
        UserInfoModel userInfoModel = transferRequest(bindRequest.getLoginRequest());
        int userId = userInfoMapper.getUserId(userInfoModel);
        userInfoModel.setId(userId);
        userInfoModel.setWeixin(bindRequest.getWxNo());
        int i = userInfoMapper.updateUserInfo(userInfoModel);
        return i == 1;
    }
}
