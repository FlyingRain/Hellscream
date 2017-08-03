package com.flyingrain.translate.user.service.services;

import com.flyingrain.translate.user.api.request.UserAuthRequest;
import com.flyingrain.translate.user.api.request.LoginRequest;
import com.flyingrain.translate.user.api.response.LoginResult;

/**
 * Created by wally on 17-7-10.
 */
public interface UserAuthorityService {


    /**
     * 用户登陆
     * @param request
     * @return 用户Id
     */
    LoginResult userLogin(LoginRequest request);

    /**
     * 校验用户访问权限
     * @param authRequest
     * @return
     */
    boolean authRequest(UserAuthRequest authRequest);

}
