package com.flyingrain.translate.auth.api.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 验签请求
 * Created by wally on 17-7-20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyRequest {

    /**
     * 签名
     */
    private String sign;
    /**
     * 原文
     */
    private String param;

    /**
     * 服务Id
     */
    private String serviceId;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
