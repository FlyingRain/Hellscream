package com.flyingrain.translate.auth.service.services.impl;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.service.services.VerifyService;
import com.flyingrain.translate.auth.service.services.config.AuthConfig;
import com.flyingrain.translate.framework.lang.common.Algorithm;
import com.flyingrain.translate.framework.lang.utils.SignUtil;
import com.flyingrain.translate.framework.lang.utils.model.VerifySignModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 8/3/17.
 */
@Component
public class VerifyServiceImpl implements VerifyService{

    @Autowired
    private AuthConfig authConfig;

    @Override
    public boolean verifySign(VerifyRequest request) {

        VerifySignModel verifySignModel = new VerifySignModel();
        verifySignModel.setAlgorithm(Algorithm.RSA);
        verifySignModel.setPlainContent(request.getParam());
        verifySignModel.setSign(request.getSign());
        verifySignModel.setPrivate(false);
        verifySignModel.setKeyPath(authConfig.getPubKeyPath());

        return SignUtil.verifySign(verifySignModel);
    }
}
