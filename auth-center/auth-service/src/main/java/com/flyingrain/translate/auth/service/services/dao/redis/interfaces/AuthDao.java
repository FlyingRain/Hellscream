package com.flyingrain.translate.auth.service.services.dao.redis.interfaces;

/**
 * 鉴权结果缓存
 * Created by wally on 17-7-26.
 */
public interface AuthDao {


    /**
     * 缓存结果
     * @param token
     * @param url
     * @return
     */
    int insertAuthResult(String token,String url);




}
