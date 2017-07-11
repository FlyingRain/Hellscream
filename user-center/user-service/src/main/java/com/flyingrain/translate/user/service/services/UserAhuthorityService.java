package com.flyingrain.translate.user.service.services;

import com.flyingrain.translate.user.api.request.LoginRequest;

/**
 * Created by wally on 17-7-10.
 */
public interface UserAhuthorityService {


    /**
     * 用户登陆
     * @param request
     * @return 用户Id
     */
    int userLogin(LoginRequest request);



}
