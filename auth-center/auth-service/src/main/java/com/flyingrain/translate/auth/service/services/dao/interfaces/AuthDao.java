package com.flyingrain.translate.auth.service.services.dao.interfaces;

/**
 * 鉴权
 * Created by wally on 17-7-26.
 */
public interface AuthDao {

    /**
     * 鉴权
     * @param userId
     * @param url
     * @return
     */
    boolean authUrl(String userId,String url);

}
