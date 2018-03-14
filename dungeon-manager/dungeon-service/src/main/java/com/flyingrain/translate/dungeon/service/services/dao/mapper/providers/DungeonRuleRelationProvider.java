package com.flyingrain.translate.dungeon.service.services.dao.mapper.providers;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by wally on 17-12-20.
 */
public class DungeonRuleRelationProvider {

    private Logger logger = LoggerFactory.getLogger(DungeonRuleRelationProvider.class);

    /**
     * 生成查询sql
     * 目前只支持一个条件
     *
     * @param param
     * @return
     */
    public String queryDungeonByRule(Map param) {
        DungeonRuleModel ruleModel = (DungeonRuleModel) param.get("dungeonRule");

        return ruleModel == null ?
                "select distinct dungeon_id from dungeon_rule_relation " :
                "select dungeon_id from dungeon_rule_relation drr join dungeon_rule dr on (drr.rule_id = dr.id and dr.rule_type=#{dungeonRule.rule_type} and dr.rule_param=#{dungeonRule.rule_type}) ";
    }

}
