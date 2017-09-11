package com.flyingrain.translate.dungeon.service.services.dao.mapper;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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


}
