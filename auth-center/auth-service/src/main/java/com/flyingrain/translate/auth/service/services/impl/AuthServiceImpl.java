package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.AuthRequest;
import com.flyingrain.translate.auth.api.responses.AuthResponse;
import com.flyingrain.translate.auth.service.services.AuthService;
import com.flyingrain.translate.user.api.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 8/3/17.
 */
@Component
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserResource userResource;

    @Override
    public AuthResponse authority(AuthRequest request) {
        return null;
    }
}
