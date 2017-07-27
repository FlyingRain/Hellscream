package com.flyingrain.translate.auth.service.services.dao.redis.interfaces;

/**
 * 用户相关操作
 * Created by wally on 17-7-26.
 */
public interface UserDao {

    /**
     * 获取用户Id
     * @param token
     * @return
     */
    String getUserId(String token);


    /**
     * 插入用户token
     * @param userId 用户Id
     * @param token token
     * @param expiryTime 时限(单位：天)
     * @return
     */
    void insertUserToken(String userId,String token,int expiryTime);


    /**
     * 使token失效
     * @param token
     * @return
     */
    void delToken(String token);




}
