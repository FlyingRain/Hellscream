package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.requests.WxBind;
import com.flyingrain.translate.auth.api.requests.WxLogin;
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


    /**
     * 登出
     * @param userId
     * @return
     */
    String logoff(String userId);


    /**
     * 微信登陆
     * @param wxLogin
     * @return
     */
    LoginResponse wxLogin(WxLogin wxLogin);

    /**
     * 微信号绑定
     * @param wxBindRequest
     * @return
     */
    boolean wxBind(WxBind wxBindRequest);


}
