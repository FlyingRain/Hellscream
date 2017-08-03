package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;

/**
 * Created by wally on 8/3/17.
 */
public interface VerifyService {

    /**
     * 验签服务
     * @param request
     * @return
     */
    boolean verifySign(VerifyRequest request);
}
