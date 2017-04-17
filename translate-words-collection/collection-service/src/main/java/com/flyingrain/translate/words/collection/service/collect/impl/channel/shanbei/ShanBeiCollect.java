package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.words.collection.service.common.ChannelCode;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.ChannelCollect;
import com.flyingrain.translate.words.collection.service.collect.impl.words.Result;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine.QueryResult;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine.WordDefinition;
import com.flyingrain.translate.words.collection.service.collect.impl.words.WordDefine;
import com.flyingrain.translate.words.collection.service.common.ErrorType;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/11/17.
 */
@Component
public class ShanBeiCollect extends ChannelCollect {

    private Logger logger = LoggerFactory.getLogger(ShanBeiCollect.class);

    private String url;
    @Autowired
    private Environment environment;

    private final ObjectMapper objectMapper = new ObjectMapper();;

    @PostConstruct
    public void init(){
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        url = environment.getProperty("shanbei.url");
    }
    @Override
    protected String sendToChannel(String word) {
        logger.info("send " + word + "to shanbei!");

        if (StringUtils.isEmpty(url)) {
            logger.error("shanbei url is null!");
        }
        return HttpUtil.sendGet(url + word);
    }

    @Override
    protected Result parseResult(String result) {
        Result<WordDefinition> realResult = new Result<>();
        if (result==null || result.length() < 20) {
            logger.warn("result length is abnormal!");
            realResult.setSuccess(false);
            realResult.setMsg(result);
            return realResult;
        }

        try {
            logger.info("start parse result!");
            QueryResult queryResult = objectMapper.readValue(result, QueryResult.class);
            realResult.setCode(queryResult.getStatus_code() + "");
            realResult.setMsg(queryResult.getMsg());
            realResult.setQueryResult(queryResult.getData());
            if ("SUCCESS".equals(queryResult.getMsg())) {
                realResult.setSuccess(true);
            }
            return realResult;
        } catch (IOException e) {
            logger.error("parse result error!result is [{}]", result, e);
        }

        return null;
    }

    @Override
    protected Result<WordDefine> transferResult(Result result) {
        Result<WordDefine> commonResult = new Result<>();
        if (result == null) {
            logger.error("result is null!");
            commonResult.setSuccess(false);
            commonResult.setMsg(ErrorType.NULL_ERROR.msg);
            commonResult.setCode(ErrorType.NULL_ERROR.code + "");
            return commonResult;
        }
        WordDefine wordDefine = new WordDefine();

        WordDefinition wordDefinition = (WordDefinition) result.getQueryResult();
        commonResult.setMsg(result.getMsg());
        commonResult.setCode(result.getCode() + "");
        commonResult.setSuccess(result.isSuccess());
        if (wordDefinition == null || !result.isSuccess()) {
            logger.error("wordDefinition is null!");
            return commonResult;
        }
        wordDefine.setChannel_code(ChannelCode.SHANBEI.channelCode);
        wordDefine.setChannel_word_id(wordDefinition.getId() + "");
        wordDefine.setUk_pronunciation(wordDefinition.getPronunciations().getUk());
        wordDefine.setUs_pronunciation(wordDefinition.getPronunciations().getUs());
        wordDefine.setEn_adj(wordDefinition.getEn_definitions().getAdj());
        wordDefine.setEn_adv(wordDefinition.getEn_definitions().getAdv());
        wordDefine.setEn_n(wordDefinition.getEn_definitions().getN());
        wordDefine.setEn_v(wordDefinition.getEn_definitions().getV());
        wordDefine.setContent(wordDefinition.getContent());
        //words.setHas_audio(wordDefinition.isHas_audio());
        wordDefine.setMeans(wordDefinition.getDefinition());
        wordDefine.setUk_audio_address(wordDefinition.getAudio_addresses().getUk());
        wordDefine.setUs_audio_address(wordDefinition.getAudio_addresses().getUs());
        if (CollectionUtils.isEmpty(wordDefine.getUk_audio_address())) {
            List<String> uk = new ArrayList<>();
            uk.add(wordDefinition.getUk_audio());
            wordDefine.setUk_audio_address(uk);
        } else {
            wordDefine.getUk_audio_address().add(wordDefinition.getUk_audio());
        }
        if (CollectionUtils.isEmpty(wordDefine.getUs_audio_address())) {
            List<String> us = new ArrayList<>();
            us.add(wordDefinition.getUs_audio());
            wordDefine.setUk_audio_address(us);
        } else {
            wordDefine.getUs_audio_address().add(wordDefinition.getUs_audio());
        }
        commonResult.setQueryResult(wordDefine);
        return commonResult;
    }
}
