package com.flyingrain.translate.words.collection.service.collect.impl.channel;

import com.flyingrain.translate.words.collection.service.collect.impl.words.WordDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 4/11/17.
 */
public abstract class ChannelCollect {
    private Logger logger = LoggerFactory.getLogger(ChannelCollect.class);

    public WordDefine query(String word) {
        logger.info("start to query word:" + word);
        String queryResult = sendToChannel(word);
        Result channelResult = parseResult(queryResult);
        if (channelResult==null||!channelResult.isSuccess()) {
            logger.warn("query failed! " + channelResult);
            return null;
        }
        return transferResult(channelResult);
    }

    protected abstract String sendToChannel(String word);

    protected abstract Result parseResult(String result);

    protected abstract WordDefine transferResult(Result result);
}

