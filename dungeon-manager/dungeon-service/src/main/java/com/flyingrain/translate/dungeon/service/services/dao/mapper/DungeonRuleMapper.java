package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wally on 9/11/17.
 */
public interface DungeonRuleMapper {

    /**
     * 插入一个副本规则
     * @param ruleModel
     * @return
     */
    @Insert("insert into dungeon_rule (rule,desc,rule_param,rule_type,is_active) values " +
            "(#{ruleModel.rule},#{ruleModel.desc},#{ruleModel.rule_param},#{ruleModel.rule_type},#{ruleModel.is_active})")
    @Options(useGeneratedKeys = true, keyProperty = "ruleModel.id")
    int insertDungeonRule(@Param("ruleModel") DungeonRuleModel ruleModel);

    /**
     * 根据Id查找副本规则
     * @param id
     * @return
     */
    @Select("select id,rule,desc,rule_param,rule_type,is_active,data_added,last_modified from dungeon_rule where id=#{id}")
    DungeonRuleModel getRuleById(int id);

    /**
     * 根据副本Id查询副本限制
     * @param dungeonId
     * @return
     */
    @Select("select dr.id as id,dr.rule as rule,dr.desc as desc,dr.rule_param as rule_param,dr.rule_type as rule_type,dr.is_active as is_active from dungeon_rule dr join dungeon_rule_relation drr on (dr.id=drr.rule_id and drr.dungeon_id=#{dungeonId}) where drr.is_active=#{isActive}")
    List<DungeonRuleModel> getRulesByDungeonId(@Param("dungeonId") int dungeonId,@Param("isActive")int isActive);


    /**
     * 根据限制获取Id
     * @param ruleModel
     * @return
     */
    @Select("select id from dungeon_rule where rule_type=#{dungeonRuleModel.rule_type} and rule_param=#{dungeonRuleModel.rule_param}")
    int getLimitId(@Param("dungeonRuleModel") DungeonRuleModel ruleModel);


}
