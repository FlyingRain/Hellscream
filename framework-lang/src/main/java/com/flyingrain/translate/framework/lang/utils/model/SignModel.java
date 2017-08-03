package com.flyingrain.translate.framework.lang.utils.model;

import com.flyingrain.translate.framework.lang.common.Algorithm;

/**
 * 签名请求
 * Created by wally on 8/3/17.
 */
public class SignModel {

    /**
     * 原文
     */
    private String plainContent;
    /**
     * 算法
     * @see Algorithm
     */
    private Algorithm algorithm;

    /**
     * 签名密钥路径
     */
    private String keyPath;
    /**
     * 密钥类型（是否是私钥）
     */
    private boolean isPrivate;
    /**
     * 获取密钥的密码
     */
    private String password;

    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
