package com.flyingrain.translate.words.collection.service.collect.impl;

import com.flyingrain.translate.words.collection.model.WordType;
import com.flyingrain.translate.words.collection.service.collect.impl.words.WordDefine;
import com.flyingrain.translate.words.collection.service.dao.mapper.ENMeanMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordMapper;
import com.flyingrain.translate.words.collection.service.dao.mapper.WordTypeRelationsMapper;
import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import com.flyingrain.translate.words.collection.service.dao.model.Word;
import com.flyingrain.translate.words.collection.service.dao.model.WordTypeRelations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wally on 4/12/17.
 */
@Component
public class WordSaver {

    private Logger logger = LoggerFactory.getLogger(WordSaver.class);
    @Autowired
    private WordMapper wordMapper;

    @Autowired
    private ENMeanMapper enMeanMapper;
    @Autowired
    private WordTypeRelationsMapper relationsMapper;


    public boolean saveWord(WordDefine word) {
        SaveResult saveResult = saveWordContent(word);
        if(!saveResult.result){
            return false;
        }
        boolean mresult = saveENMean(word,saveResult.id);
        if(!mresult){
            logger.error("save enMean failed! wordId: " + saveResult.id);
        }
        boolean tresult = saveTypeRelations(word,saveResult.id);
        if(!tresult){
            logger.error("save relation failed wordId : " + saveResult.id);
        }
        return true;
    }

    private SaveResult saveWordContent(WordDefine word) {
        if(isExistWord(word.getContent())){
            return new SaveResult(false,0);
        }
        Word wordConetnt = new Word();
        wordConetnt.setChannel_code(word.getChannel_code());
        wordConetnt.setChannel_word_id(word.getChannel_word_id());
        wordConetnt.setHas_audio(word.isHas_audio()?1:0);
        wordConetnt.setMean(word.getMeans());
        wordConetnt.setUk_pronunciation(word.getUk_pronunciation());
        wordConetnt.setUs_pronunciation(word.getUs_pronunciation());
        wordConetnt.setWord(word.getContent());
        logger.info("start to save word : " + word);
        wordMapper.insertWord(wordConetnt);
        return new SaveResult(true,wordConetnt.getId());
    }
    private boolean saveENMean(WordDefine wordDefine, int wordId){
        ENMean enMean = new ENMean();
        if(!CollectionUtils.isEmpty(wordDefine.getEn_adj())){
            enMean.setAdj(listToString(wordDefine.getEn_adj()));
        }
        if(!CollectionUtils.isEmpty(wordDefine.getEn_adv())){
            enMean.setAdv(listToString(wordDefine.getEn_adv()));
        }
        if(!CollectionUtils.isEmpty(wordDefine.getEn_n())){
            enMean.setN(listToString(wordDefine.getEn_n()));
        }
        if(!CollectionUtils.isEmpty(wordDefine.getEn_v())){
            enMean.setV(listToString(wordDefine.getEn_v()));
        }
        enMean.setWord_id(wordId);
        if(!CollectionUtils.isEmpty(wordDefine.getEn_vi())){
            enMean.setVi(listToString(wordDefine.getEn_vi()));
        }
        if(!CollectionUtils.isEmpty(wordDefine.getEn_vt())){
            enMean.setVt(listToString(wordDefine.getEn_vt()));
        }
        enMeanMapper.insertEnMean(enMean);
        return true;
    }

    private String listToString(List<String> temp){
        String adj = "";
        for (String adj1 : temp) {
            adj = adj + adj1 + "|";
        }
        return adj.substring(0,adj.length()-1);
    }


    private boolean saveTypeRelations(WordDefine wordDefine, int wordId){
        int typeCode = wordDefine.getType();
        if(!WordType.isExist(typeCode)){
            logger.error("wrong type ! type : " + typeCode);
            return false;
        }
        if(isExistRelation(typeCode,wordId)){
            logger.info("relation has been exist!");
            return false;
        }
        relationsMapper.insertRelation(wordId,typeCode);
        return true;
    }


    private boolean isExistRelation(int typeCode,int wordId){
        WordTypeRelations relations = relationsMapper.getRelation(wordId,typeCode);
        if(relations==null){
            return false;
        }
        return true;
    }

    private boolean isExistWord(String word){
        Word word1 = wordMapper.getWord(word);
        if(word1==null){
            return false;
        }
        return true;
    }

    class SaveResult{
        boolean result;
        int id;

        public SaveResult(boolean result, int id) {
            this.result = result;
            this.id = id;
        }
    }
}
