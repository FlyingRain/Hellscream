package com.flyingrain.translate.auth.service.resourceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.auth.api.UserAuthResource;
import com.flyingrain.translate.auth.api.requests.AuthLoginRequest;
import com.flyingrain.translate.auth.api.requests.AuthRegisterRequest;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.UserService;
import com.flyingrain.translate.auth.service.services.VerifyService;
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

    private static String ENCRYPTPARAM = "\"password\":";

    @Autowired
    private UserService userService;
    @Autowired
    private VerifyService verifyService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public LoginResponse login(VerifyRequest request) {
        String param = request.getParam();
        int i = param.indexOf(ENCRYPTPARAM);
        AuthLoginRequest loginRequest;
        try {
            loginRequest = objectMapper.readValue(param, AuthLoginRequest.class);
        } catch (IOException e) {
            logger.error("deserialize param failed!", e);
            throw new FlyException(AuthError.PARASEFAIL.getCode(), AuthError.PARASEFAIL.getMsg());
        }
        String realPass = "\"" + verifyService.decrypt(loginRequest.getPassword()) + "\"";
        int passend = param.indexOf("&", i);
        String signString = "";
        if (passend < 0)
            signString = param.replace(param.substring(i + ENCRYPTPARAM.length()), realPass)+"}";
        else
            signString = param.replace(param.substring(i + ENCRYPTPARAM.length(), passend), realPass);
        request.setParam(signString);
        if(!verifyService.verifySign(request)){
            throw  new FlyException(AuthError.VERIFYSIGNFAIL.getCode(),AuthError.VERIFYSIGNFAIL.getMsg());
        }
        return userService.login(loginRequest);
    }

    @Override
    public LoginResponse wxLogin(VerifyRequest verifyRequest) {
        return null;
    }

    @Override
    public boolean wxBind(VerifyRequest verifyRequest) {
        return false;
    }

    @Override
    public RegisterResponse register(VerifyRequest request) {
        String param = request.getParam();
        int i = param.indexOf(ENCRYPTPARAM);
        AuthRegisterRequest registerRequest;
        try {
            registerRequest = objectMapper.readValue(request.getParam(), AuthRegisterRequest.class);
        } catch (IOException e) {
            logger.error("deserialize param failed!", e);
            throw new FlyException(AuthError.PARASEFAIL.getCode(), AuthError.PARASEFAIL.getMsg());
        }
        String realPass = "\"" + verifyService.decrypt(registerRequest.getPassword()) + "\"";
        int passend = param.indexOf("&", i);
        String signString = "";
        if (passend < 0)
            signString = param.replace(param.substring(i + ENCRYPTPARAM.length()), realPass)+"}";
        else
            signString = param.replace(param.substring(i + ENCRYPTPARAM.length(), passend), realPass);
        request.setParam(signString);
        if(!verifyService.verifySign(request)){
            throw  new FlyException(AuthError.VERIFYSIGNFAIL.getCode(),AuthError.VERIFYSIGNFAIL.getMsg());
        }

        return userService.register(registerRequest);
    }

    @Override
    public String logoff(String userId) {
        return userService.logoff(userId);
    }


}
