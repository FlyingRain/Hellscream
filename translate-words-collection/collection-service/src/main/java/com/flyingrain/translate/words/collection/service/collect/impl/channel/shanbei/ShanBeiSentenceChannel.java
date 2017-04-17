package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.ChannelCollectSentence;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.QueryRequest;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.samplesentences.Sentence;
import com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.samplesentences.SentenceResult;
import com.flyingrain.translate.words.collection.service.collect.impl.words.Result;
import com.flyingrain.translate.words.collection.service.collect.impl.words.SentenceDefine;
import com.flyingrain.translate.words.collection.service.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
@Component
public class ShanBeiSentenceChannel extends ChannelCollectSentence {

    private Logger logger = LoggerFactory.getLogger(ShanBeiSentenceChannel.class);

    private String url;
    @Autowired
    private Environment environment;
    private final ObjectMapper objectMapper = new ObjectMapper();;

    @PostConstruct
    public void init() {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        url = environment.getProperty("shanbei.sentence");
    }

    @Override
    public String sendToChannel(QueryRequest queryRequest) {
        logger.info("start to send " + queryRequest + " to shanbei to get sentence!");
        if(StringUtils.isEmpty(url)){
            logger.error("sentence url is null!");
            return null;
        }
        url = url + queryRequest.getChannelWordId();
        return HttpUtil.sendGet(url);
    }

    @Override
    public Result parseResult(String result) {
        Result<SentenceResult> channelResult = new Result<>();
        try {
            SentenceResult sentenceResult = objectMapper.readValue(result,SentenceResult.class);
            channelResult.setCode(sentenceResult.getStatus_code()+"");
            channelResult.setMsg(sentenceResult.getMsg());
            channelResult.setQueryResult(sentenceResult);
            return channelResult;
        } catch (IOException e) {
            logger.error("parse result failed!",e);
        }
        return null;
    }

    @Override
    public Result<SentenceDefine> transferResult(Result result) {
        SentenceResult channelresult = (SentenceResult)result.getQueryResult();
        List<Sentence> sentenceList = channelresult.getData();
        SentenceDefine sentenceDefine = new SentenceDefine();
        List<SentenceDefine.Mysentence>  mysentences = new ArrayList<>();
        //最多存5个例句
        int i=0;
        while (i<5 || i<=sentenceList.size()){
            Sentence sentence = sentenceList.get(i);
            SentenceDefine.Mysentence mysentence = sentenceDefine.getMySentenceInstance();
            mysentence.setFirst(sentence.getFirst());
            mysentence.setLast(sentence.getLast());
            mysentence.setTranslation(sentence.getTranslation());
            mysentences.add(mysentence);
            i++;
        }
        sentenceDefine.setWord(sentenceList.get(0).getWord());
        sentenceDefine.setChannelWordId(sentenceList.get(0).getVocabulary_id());
        sentenceDefine.setMysentences(mysentences);

        Result<SentenceDefine> realResult = new Result<>();
        realResult.setCode(result.getCode());
        realResult.setMsg(result.getMsg());
        realResult.setSuccess(true);
        realResult.setQueryResult(sentenceDefine);
        return realResult;
    }
}
