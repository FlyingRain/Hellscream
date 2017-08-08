package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.AuthRequest;

/**
 * Created by wally on 8/3/17.
 */
public interface AuthService {

    boolean authority(AuthRequest request);

}
