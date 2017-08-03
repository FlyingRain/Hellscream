package com.flyingrain.translate.framework.lang.common;

/**
 * 签名算法
 * Created by wally on 8/3/17.
 */
public enum Algorithm {

    RSA("rsa","rsa算法");

    private String algorithm;

    private String desc;

    Algorithm(String algorithm, String desc) {
        this.algorithm = algorithm;
        this.desc = desc;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
