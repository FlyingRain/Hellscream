package com.flyingrain.translate.user.service.services.impl;

import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.UserInfoResult;
import com.flyingrain.translate.user.service.services.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-11.
 */
@Component
public class UserServiceImpl implements UserService{
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return 0;
    }

    @Override
    public UserInfoResult getUserInfoById(int userId) {
        return null;
    }
}
