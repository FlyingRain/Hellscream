package com.flyingrain.translate.auth.service.services.dao.impl.userCenter.intf;

import com.flyingrain.translate.user.api.request.LoginRequest;

/**
 * Created by wally on 8/2/17.
 */
public interface UserCenterDao {

    /**
     * 验证用户登陆信息
     * @param loginRequest
     * @return
     */
    boolean authentity(LoginRequest loginRequest);



}
