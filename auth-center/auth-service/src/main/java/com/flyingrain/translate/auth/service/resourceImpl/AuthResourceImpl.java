package com.flyingrain.translate.auth.service.resourceImpl;

import com.flyingrain.translate.auth.api.AuthResource;
import com.flyingrain.translate.auth.api.requests.AuthRequest;
import com.flyingrain.translate.auth.service.services.AuthService;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-30.
 */
@Component
@Resource
public class AuthResourceImpl implements AuthResource {

    @Autowired
    private AuthService authService;

    @Override
    public boolean authority(AuthRequest request) {
        return authService.authority(request);
    }
}
