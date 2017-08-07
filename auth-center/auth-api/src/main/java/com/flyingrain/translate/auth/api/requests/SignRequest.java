package com.flyingrain.translate.auth.api.requests;

/**
 * 签名请求
 * Created by wally on 8/7/17.
 */

public class SignRequest {
    /**
     * 服务Id
     */
    private String serviceId;
    /**
     * 原文
     */
    private String plainContent;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }
}
