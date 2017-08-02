package com.flyingrain.translate.auth.service.resourceImpl;

import com.flyingrain.translate.auth.api.UserAuthResource;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.api.responses.LoginResponse;
import com.flyingrain.translate.auth.api.responses.RegisterResponse;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 7/26/17.
 */
@Component
@Resource
public class UserAuthResourceImpl implements UserAuthResource {

    @Override
    public LoginResponse login(VerifyRequest request) {
        return null;
    }

    @Override
    public RegisterResponse register(VerifyRequest request) {
        return null;
    }
}
