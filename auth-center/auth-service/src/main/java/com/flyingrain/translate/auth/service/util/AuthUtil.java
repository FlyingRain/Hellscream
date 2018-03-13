package com.flyingrain.translate.auth.service.util;

import com.flyingrain.translate.auth.api.requests.MessageRequest;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;
import com.flyingrain.translate.auth.service.common.AuthError;
import com.flyingrain.translate.auth.service.services.VerifyService;
import com.flyingrain.translate.auth.service.services.config.AuthConfig;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.utils.EncryptUtil;
import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用加解密,验签处理
 * Created by wally on 3/9/18.
 */
@Component
public class AuthUtil {

    @Autowired
    private VerifyService verifyService;

    @Autowired
    private AuthConfig authConfig;

    private Logger logger = LoggerFactory.getLogger(AuthUtil.class);

    /**
     * 解密报文, 并验签
     *
     * @param messageRequest
     * @param <T>
     * @return
     */
    public <T> T authRequest(MessageRequest messageRequest, Class<T> type) {
        String plainText = EncryptUtil.decryptBy3DES(authConfig.getSecretKeyPath(), messageRequest.getMessage());
        VerifyRequest verifyRequest = ObjectUtil.jsonToObject(plainText, VerifyRequest.class);
        logger.info("start to verify sign![{}]", verifyRequest.getSign());
        if (verifyService.verifySign(verifyRequest)) {
            return ObjectUtil.jsonToObject(verifyRequest.getParam(), type);
        } else {
            logger.error("sign failed!");
            throw new FlyException(AuthError.VERIFYSIGNFAIL.getCode(), AuthError.VERIFYSIGNFAIL.getMsg());
        }
    }
}
