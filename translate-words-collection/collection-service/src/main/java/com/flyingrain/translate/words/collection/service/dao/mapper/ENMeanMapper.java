package com.flyingrain.translate.words.collection.service.dao.mapper;

import com.flyingrain.translate.words.collection.service.dao.model.ENMean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wally on 4/12/17.
 */
public interface ENMeanMapper {


    @Insert("insert en_mean (word_id,n,adj,adv,v,vt,vi) values " +
            "       (#{enMean.word_id},#{enMean.n},#{enMean.adj},#{enMean.adv},#{enMean.v},#{enMean.vi},#{enMean.vt})")
    int insertEnMean(@Param("enMean") ENMean enMean);

    @Select("select * from en_mean where word_id=#{wordId}")
    ENMean getMeanByWordId(int wordId);
}
