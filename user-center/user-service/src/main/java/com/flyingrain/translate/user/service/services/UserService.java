package com.flyingrain.translate.user.service.services;

import com.flyingrain.translate.user.api.request.UserInfo;
import com.flyingrain.translate.user.api.response.UserInfoResult;

/**
 * Created by wally on 17-7-10.
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param userInfo
     * @return 用户Id
     */
    int insertUserInfo(UserInfo userInfo);


    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    UserInfoResult getUserInfoById(int userId);

}
