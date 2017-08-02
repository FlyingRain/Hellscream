package com.flyingrain.translate.auth.service.services.dao.impl;

import com.flyingrain.translate.auth.service.services.dao.interfaces.UserDao;
import com.flyingrain.translate.auth.service.services.dao.impl.redis.intf.RUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-27.
 */
@Component
public class UserDaoImpl implements UserDao {


    @Autowired
    private RUserDao rUserDao;

    @Override
    public String getUserId(String token) {
        return rUserDao.getUserId(token);
    }

    @Override
    public void insertUserToken(String userId, String token, int expiryTime) {
        rUserDao.insertUserToken(userId,token,expiryTime);
    }

    @Override
    public void delToken(String token) {
        rUserDao.delToken(token);
    }
}
