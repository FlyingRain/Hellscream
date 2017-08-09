package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.UserInfoResult;
import com.flyingrain.translate.user.service.services.UserService;
import com.flyingrain.translate.user.service.services.common.Constants;
import com.flyingrain.translate.user.service.services.common.RoleEnum;
import com.flyingrain.translate.user.service.services.common.UserCenterExceptionEnum;
import com.flyingrain.translate.user.service.services.dao.mapper.RoleMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserInfoMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserLoginMapper;
import com.flyingrain.translate.user.service.services.dao.mapper.UserRoleRelationMapper;
import com.flyingrain.translate.user.service.services.dao.model.UserInfoModel;
import com.flyingrain.translate.user.service.services.dao.model.UserLoginModel;
import com.flyingrain.translate.user.service.services.dao.model.UserRoleRelationModel;
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

    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public int insertUserInfo(UserInfo userInfo) {
        UserInfoModel model = transferUserInfoModel(userInfo);
        //插入用户信息
        logger.info("start to insert ");
        int i = userInfoMapper.insertUserInfo(model);
        if (i != 1) {
            logger.error("insert failed ! number is [{}]", i);
            throw new FlyException(UserCenterExceptionEnum.InsertFailure.getCode(), UserCenterExceptionEnum.InsertFailure.getMsg());
        }
        UserLoginModel loginModel = new UserLoginModel();
        loginModel.setUser_id(model.getId());
        loginModel.setPassword(userInfo.getPassword());
        //插入用户登陆
        logger.info("start to insert password userId :[{}]", model.getId());
        int m = loginMapper.insertUserLogin(loginModel);
        if (m != 1) {
            logger.error("insert password failed! userId:[{}]", model.getId());
            throw new FlyException(UserCenterExceptionEnum.InsertFailure.getCode(), UserCenterExceptionEnum.InsertFailure.getMsg());
        }
        //插入用户角色(新增用户均为普通角色)
        int roleId = roleMapper.getRoleId(RoleEnum.COMMON.getRole());
        UserRoleRelationModel relationModel = new UserRoleRelationModel();
        relationModel.setIs_active(Constants.ACTIVE);
        relationModel.setRole_id(roleId);
        relationModel.setUser_id(model.getId());
        userRoleRelationMapper.insertUserRoleRelation(relationModel);
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
        result.setUserId(model.getId());
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
