package com.flyingrain.translate.dungeon.service.services.dao.mapper.handlers;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wally on 11/9/17.
 */
@EnableTransactionManagement
public class DungeonInstanceHandler implements ResultHandler{
    @Override
    public void handleResult(ResultContext resultContext) {

    }
}
