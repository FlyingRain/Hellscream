package com.flyingrain.translate.words.collection.service.collect.impl.channel;

import com.flyingrain.translate.words.collection.service.collect.impl.words.Words;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 4/11/17.
 */
public abstract class ChannelCollect {
    private Logger logger = LoggerFactory.getLogger(ChannelCollect.class);

    public Words query(String word) {
        logger.info("start to query word:" + word);
        String queryResult = sendToChannel(word);
        Result channelResult = parseResult(queryResult);
        if (!channelResult.isSuccess()) {
            logger.warn("query failed! " + channelResult);
            return null;
        }
        return transferResult(channelResult);
    }

    protected abstract String sendToChannel(String word);

    protected abstract Result parseResult(String result);

    protected abstract Words transferResult(Result result);
}

