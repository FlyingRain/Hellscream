package com.flyingrain.translate.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户信息
 * Created by wally on 1/10/18.
 */
public class UserContext {

    private static Logger logger = LoggerFactory.getLogger(UserContext.class);
    private static int userId;

    public synchronized static void setUserId(int newUserId){
        if(userId==0){
            userId = newUserId;
        }else{
            logger.warn("userId had exited!userId :[{}]",userId);
        }
    }

    public static int getUserId(){
        return userId;
    }
}
