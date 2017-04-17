package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.Word;
import org.apache.ibatis.annotations.*;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wally on 4/12/17.
 */
public interface WordMapper {

    @Insert("insert into words (word,channel_word_id,uk_pronunciation,channel_code,has_audio,us_pronunciation,default_audio,mean)" +
            "values (#{word.word},#{word.channel_word_id},#{word.uk_pronunciation},#{word.channel_code},#{word.has_audio},#{word.us_pronunciation},#{word.default_audio},#{word.mean})")
    @Options(useGeneratedKeys = true,keyProperty = "word.id")
    int insertWord(@Param("word") Word word);


    @Select("select id,word,channel_word_id,has_sentences,uk_pronunciation,us_pronunciation,channel_code,default_audio,mean from words where word=#{word}")
    Word getWord(String word);

    @Select("select * from words where id=#{wordId}")
    Word getWordById(String wordId);

    @Select("select id,word from words where has_sentences=0 limit 1000")
    List<Word> getNoSentenceWords();


    @Update("update words set has_sentences=#{status} where word=#{word}")
    int updateWordSentenceStatus(@Param("status") int status,@Param("word") String word);


}
