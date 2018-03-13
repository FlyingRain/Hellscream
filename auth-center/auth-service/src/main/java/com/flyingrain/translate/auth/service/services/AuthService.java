package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.AuthRequest;
import com.flyingrain.translate.auth.api.responses.AuthResponse;

/**
 * Created by wally on 8/3/17.
 */
public interface AuthService {

    AuthResponse authority(AuthRequest request);



}
