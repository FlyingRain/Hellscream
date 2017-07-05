package com.flyingrain.translate.plan.service.services.dao.mapper;

import com.flyingrain.translate.plan.service.services.dao.mapper.providers.UserWordRelationProvider;
import com.flyingrain.translate.plan.service.services.dao.model.UserWordRelation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
public interface UserWordRelationMapper {

    /**
     * 为用户插入一条新单词
     * @param wordRelation
     * @return
     */
    @Insert("insert into user_word_relation (user_id,word_id,proficiency,plan_id) values " +
            "(#{userWordRelation.user_id},#{userWordRelation.word_id},#{userWordRelation.proficiency},#{userWordRelation.plan_id})")
    int insertProficiency(@Param("userWordRelation")UserWordRelation wordRelation);

    /**
     * 更新某个单词的熟练度
     * @param wordRelation
     * @return
     */
    @Update("update user_word_relation set proficiency=#{userWordRelation} where user_id=#{userWordRelation.user_id} and word_id=#{userWordRelation.word_id}")
    int updateproficiency(@Param("userWordRelation") UserWordRelation wordRelation);

    @Delete("delete from user_word_relation where plan_id=#{planId}")
    int deletePlanProficiency(@Param("planId")int planId);
    /**
     * 查询某个计划的所有单词数量
     * @param userId
     * @param planId
     * @return
     */
    @Select("select count(1) from user_word_relation where user_id=#{userId} and plan_id=#{planId} ")
    int getPlanWords(@Param("userId") int userId,@Param("planId")int planId);


    /**
     * 获取某个单词的熟练度
     * @param userId
     * @param planId
     * @param wordId
     * @return
     */
    @Select("select proficiency from user_word_relation where user_id=#{userId} and plan_id=#{planId} and word_id=#{wordId}")
    UserWordRelation getWordProficiency(@Param("userId")int userId,@Param("planId")int planId,@Param("wordId")int wordId);

    /**
     * 获取用户已经背过的单词
     * @param userId
     * @param planId
     * @return
     */
    @Select("select user_id,plan_id,proficiency,word_id from user_word_relation where user_id=#{userId} and plan_id=#{planId}")
    List<UserWordRelation> getUserPlanWords(@Param("userId")int userId,@Param("planId")int planId);

    /**
     * 根据熟练度获取单词
     * @param userId
     * @param planId
     * @param proficiency
     * @return
     */
    @Select("select user_id,plan_id,proficiency,word_id from user_word_relation where user_id=#{userId} and plan_id=#{planId} and proficiency=#{proficiency}")
    List<UserWordRelation> getWordsByProficiency(@Param("userId")int userId,@Param("planId")int planId,@Param("proficiency")int proficiency);
    /**
     * 批量插入数据(如果重复则更新数据)
     * @param userWordRelations
     * @return
     */
    @InsertProvider(type = UserWordRelationProvider.class,method = "batchInsert")
    int batchInsertOnDuplicate(@Param("userWordRelations")List<UserWordRelation> userWordRelations);

}
