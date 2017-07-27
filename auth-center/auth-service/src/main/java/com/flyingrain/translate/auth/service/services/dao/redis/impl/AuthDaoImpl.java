package com.flyingrain.translate.auth.service.services.dao.redis.impl;

import com.flyingrain.translate.auth.service.services.dao.redis.interfaces.AuthDao;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-27.
 */
@Component
public class AuthDaoImpl implements AuthDao {

    @Override
    public int insertAuthResult(String token, String url) {
        return 0;
    }
}
