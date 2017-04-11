package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.ChannelCollect;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.Result;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine.QueryResult;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine.WordDefinition;
import com.flyingrain.translate.words.collection.service.collect.impl.words.Words;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Created by wally on 4/11/17.
 */
@Component
public class ShanBeiCollect extends ChannelCollect{

    private Logger logger = LoggerFactory.getLogger(ShanBeiCollect.class);

    @Autowired
    private Environment environment;

    @Override
    protected String sendToChannel(String word) {
        logger.info("send "+ word + "to shanbei!");
        String url = environment.getProperty("shanbei.url");
        if(StringUtils.isEmpty(url)){
            logger.error("shanbei url is null!");
        }
        return HttpUtil.sendGet(url+word);
    }

    @Override
    protected Result parseResult(String result) {
        Result<WordDefinition> realResult = new Result<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        try {
            logger.info("start parse result!");
           QueryResult queryResult = objectMapper.readValue(result, QueryResult.class);
           realResult.setCode(queryResult.getStatus_code()+"");
           realResult.setMsg(queryResult.getMsg());
           realResult.setChannelResult(queryResult.getData());
           return realResult;
        } catch (IOException e) {
            logger.error("parse result error!result is [{}]", result, e);
        }

        return null;
    }

    @Override
    protected Words transferResult(Result result) {
        return null;
    }
}
