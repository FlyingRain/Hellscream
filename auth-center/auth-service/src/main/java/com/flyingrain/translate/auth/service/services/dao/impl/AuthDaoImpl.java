package com.flyingrain.translate.auth.service.services.dao.impl;

import com.flyingrain.translate.auth.service.services.dao.interfaces.AuthDao;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-7-27.
 */
@Component
public class AuthDaoImpl implements AuthDao {

    @Override
    public boolean authUrl(String userId, String url) {
        return false;
    }
}
