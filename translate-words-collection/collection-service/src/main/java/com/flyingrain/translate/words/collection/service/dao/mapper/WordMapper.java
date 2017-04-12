package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/12/17.
 */
public interface WordMapper {

    @Insert("insert into words (word,channel_word_id,uk_pronunciation,channel_code,has_audio,us_pronunciation,default_audio,mean)" +
            "values (#{word.word},#{word.channel_word_id},#{word.uk_pronunciation},#{word.channel_code},#{word.has_audio},#{word.us_pronunciation},#{word.default_audio},#{word.mean})")
    @Options(useGeneratedKeys = true,keyProperty = "word.id")
    int insertWord(@Param("word") Word word);


    @Select("select id,word,channel_word_id,uk_pronunciation,us_pronunciation,channel_code,default_audio,mean from words where word=#{word}")
    Word getWord(String word);
}
