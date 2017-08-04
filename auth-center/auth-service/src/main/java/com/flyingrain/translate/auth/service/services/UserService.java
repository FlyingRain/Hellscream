package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;

/**
 * Created by wally on 17-7-20.
 */
public interface UserService {

    /**
     * 用户登陆
     * @param authLoginRequest
     * @return
     */
    LoginResponse login(AuthLoginRequest authLoginRequest);


    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    RegisterResponse register(AuthRegisterRequest registerRequest);


    String logoff(String token);

}
