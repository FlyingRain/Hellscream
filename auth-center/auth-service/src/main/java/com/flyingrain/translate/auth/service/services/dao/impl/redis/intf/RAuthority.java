package com.flyingrain.translate.auth.service.services.dao.impl.redis.intf;

/**
 * redis鉴权缓存
 * Created by wally on 17-7-30.
 */
public interface RAuthority {

    /**
     * redis缓存鉴权结果
     * @param userId 用户
     * @param url 缓存权限
     * @param expiryMinute 缓存时限
     * @return
     */
    int insertAuth(String userId,String url,int expiryMinute);


    /**
     * 查看redis缓存中是否有该权限
     * @param userId
     * @param url
     * @return
     */
    int getAuth(String userId,String url);

}
