package com.flyingrain.translate.database.conf.test.data.mapper.resulthandler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

/**
 * Created by wally on 11/10/17.
 */
public class MyResultHandler implements ResultHandler{
    @Override
    public void handleResult(ResultContext resultContext) {
        Object object = resultContext.getResultObject();
        System.out.println(object);
    }
}
