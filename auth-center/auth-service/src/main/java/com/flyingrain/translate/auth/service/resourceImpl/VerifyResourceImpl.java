package com.flyingrain.translate.auth.service.resourceImpl;

import com.flyingrain.translate.auth.api.VerifyResource;
import com.flyingrain.translate.auth.api.requests.SignRequest;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.service.services.VerifyService;
import com.flyingrain.translate.framework.annotaions.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-30.
 */
@Component
@Resource
public class VerifyResourceImpl implements VerifyResource {

    @Autowired
    private VerifyService verifyService;

    @Override
    public boolean verify(VerifyRequest verifyRequest) {
        return verifyService.verifySign(verifyRequest);
    }

    @Override
    public String sign(SignRequest signRequest) {
        return verifyService.sign(signRequest);
    }
}
