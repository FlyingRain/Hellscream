package com.flyingrain.translate.auth.api;

import com.flyingrain.translate.auth.api.requests.VerifyRequest;

/**
 * 验签
 * Created by wally on 17-7-30.
 */
public interface VerifyResource {

    /**
     * 验签
     * @param verifyRequest 验签请求
     * @return 结果
     */
    boolean verify(VerifyRequest verifyRequest);
}
