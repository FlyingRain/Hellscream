package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.UserInfoResult;
import com.flyingrain.translate.user.service.services.UserService;
import com.flyingrain.translate.user.service.services.common.UserCenterExceptionEnum;
import com.flyingrain.translate.user.service.services.dao.mapper.UserInfoMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserLoginMapper;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import com.flyingrain.translate.user.service.services.dao.model.UserLoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wally on 17-7-11.
 */
@Component
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserLoginMapper loginMapper;

    @Override
    @Transactional
    public int insertUserInfo(UserInfo userInfo) {
        UserInfoModel model = transferUserInfoModel(userInfo);
        logger.info("start to insert ");
        int i = userInfoMapper.insertUserInfo(model);
        if (i != 1) {
            logger.error("insert failed ! number is [{}]", i);
            throw new FlyException(UserCenterExceptionEnum.InsertFailure.getCode(), UserCenterExceptionEnum.InsertFailure.getMsg());
        }
        UserLoginModel loginModel = new UserLoginModel();
        loginModel.setUser_id(model.getId());
        loginModel.setPassword(userInfo.getPassword());
        logger.info("start to insert password userId :[{}]", model.getId());
        int m = loginMapper.insertUserLogin(loginModel);
        if (m != 1) {
            logger.error("insert password failed! userId:[{}]", model.getId());
            throw new FlyException(UserCenterExceptionEnum.InsertFailure.getCode(), UserCenterExceptionEnum.InsertFailure.getMsg());
        }
        return model.getId();
    }

    private UserInfoModel transferUserInfoModel(UserInfo userInfo) {
        UserInfoModel model = new UserInfoModel();
        model.setAge(userInfo.getAge());
        model.setEmail(userInfo.getEmail());
        model.setGender(userInfo.getGender());
        model.setName(userInfo.getName());
        model.setSchool(userInfo.getSchool());
        model.setPhone(userInfo.getPhone());
        model.setPet_name(userInfo.getPetName());
        return model;
    }

    @Override
    public UserInfoResult getUserInfoById(int userId) {
        UserInfoModel model = userInfoMapper.getUserInfoById(userId);
        return transferModel(model);
    }

    private UserInfoResult transferModel(UserInfoModel model) {
        UserInfoResult result = new UserInfoResult();
        result.setPhone(model.getPhone());
        result.setSchool(model.getSchool());
        result.setEmail(model.getEmail());
        result.setAge(model.getAge());
        result.setName(model.getName());
        result.setVerifyEmail(model.getVerify_email());
        result.setVerifyPhone(model.getVerify_phone());
        return result;
    }

}
