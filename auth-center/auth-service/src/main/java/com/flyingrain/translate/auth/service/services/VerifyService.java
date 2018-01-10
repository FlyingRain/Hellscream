package com.flyingrain.translate.auth.service.services;

import com.flyingrain.translate.auth.api.requests.SignRequest;
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


    /**
     * 签名
     * @param request
     * @return
     */
    String sign(SignRequest request);


    /**
     * 解密
     * @param encrypt
     * @return
     */
    String decrypt(String encrypt);
}
