package com.flyingrain.translate.auth.service.services.dao.redis.subscribe;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 17-8-3.
 */

@Component
public class TopicMessageListener implements MessageListener{
    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
