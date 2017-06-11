package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.WordType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 4/12/17.
 */
public interface WordTypeMapper {

    @Select("select id,type_name,type_code from word_types")
    List<WordType> getWordTypes();

    @Select("select id,type_name,type_code from word_types where type_code=#{type}")
    WordType getWordType(int type);

    }
