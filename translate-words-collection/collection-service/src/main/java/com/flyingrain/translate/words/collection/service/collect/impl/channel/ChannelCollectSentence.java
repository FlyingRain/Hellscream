package com.flyingrain.translate.words.collection.service.collect.impl.channel;

import com.flyingrain.translate.words.collection.service.collect.impl.words.Result;
import com.flyingrain.translate.words.collection.service.collect.impl.words.SentenceDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 4/17/17.
 */
public abstract class ChannelCollectSentence {

    private Logger logger = LoggerFactory.getLogger(ChannelCollectSentence.class);
    public Result<SentenceDefine> querySentence(QueryRequest queryRequest){
        if(queryRequest==null){
            logger.error("query param is null!");
            return null;
        }
        String result = sendToChannel(queryRequest);
        if(result==null){
            logger.warn("channel return is null!");
            return null;
        }
        Result channelResult = parseResult(result);

        if(channelResult==null){
            logger.warn("parse result error!,result is null!");
            return null;
        }
        return transferResult(channelResult);
    }

    public abstract String sendToChannel(QueryRequest queryRequest);

    public abstract Result parseResult(String result);

    public abstract Result<SentenceDefine> transferResult(Result result);
}
