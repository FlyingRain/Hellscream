package com.flyingrain.translate.auth.service.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 8/3/17.
 */
@Component
public class AuthConfig {

    /**
     * 公钥地址
     */
    @Value("${auth.pubKey.path}")
    private String pubKeyPath;

    /**
     * 权限缓存失效时间
     */
    @Value("${auth.authority.expireMinute}")
    private int expireMinute;

    /**
     * 登陆缓存时间
     */
    @Value("${auth.login.expireDay}")
    private int expireDay;

    public String getPubKeyPath() {
        return pubKeyPath;
    }

    public void setPubKeyPath(String pubKeyPath) {
        this.pubKeyPath = pubKeyPath;
    }

    public int getExpireMinute() {
        return expireMinute;
    }


    public int getExpireDay() {
        return expireDay;
    }

    public void setExpireDay(int expireDay) {
        this.expireDay = expireDay;
    }

    public void setExpireMinute(int expireMinute) {
        this.expireMinute = expireMinute;
    }
}
