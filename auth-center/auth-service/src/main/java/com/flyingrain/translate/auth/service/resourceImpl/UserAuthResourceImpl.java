package com.flyingrain.translate.auth.service.resourceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.auth.api.UserAuthResource;
import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.auth.service.annotations.VerifySign;
import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.UserService;
import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.lang.FlyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by wally on 7/26/17.
 */
@Component
@Resource
public class UserAuthResourceImpl implements UserAuthResource {

    private Logger logger = LoggerFactory.getLogger(UserAuthResourceImpl.class);
    @Autowired
    private UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @VerifySign
    public LoginResponse login(VerifyRequest request) {
        AuthLoginRequest loginRequest;
        try {
            loginRequest = objectMapper.readValue(request.getParam(), AuthLoginRequest.class);
        } catch (IOException e) {
            logger.error("deserialize param failed!", e);
            throw new FlyException(AuthError.PARASEFAIL.getCode(), AuthError.PARASEFAIL.getMsg());
        }
        return userService.login(loginRequest);
    }

    @Override
    @VerifySign
    public RegisterResponse register(VerifyRequest request) {
        AuthRegisterRequest registerRequest;
        try {
            registerRequest = objectMapper.readValue(request.getParam(), AuthRegisterRequest.class);
        } catch (IOException e) {
            logger.error("deserialize param failed!", e);
            throw new FlyException(AuthError.PARASEFAIL.getCode(), AuthError.PARASEFAIL.getMsg());
        }
        return userService.register(registerRequest);
    }

    @Override
    public String logoff(String token) {
        return userService.logoff(token);
    }
}
