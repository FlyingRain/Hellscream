package com.flyingrain.translate.framework.lang.utils.model;

import com.flyingrain.translate.framework.lang.common.Algorithm;

/**
 * 验签请求
 * Created by wally on 8/3/17.
 */
public class VerifySignModel {

    /**
     * 签名内容
     */
    private String sign;
    /**
     * 原文
     */
    private String plainContent;
    /**
     * 用于验签的密钥路径
     */
    private String keyPath;
    /**
     * 密码
     */
    private String password;
    /**
     * 密钥是否是私钥
     */
    private boolean isPrivate;
    /**
     * 算法
     */
    private Algorithm algorithm;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
