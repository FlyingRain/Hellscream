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
     * @param param
     * @return
     */
    public String queryDungeonByRule(Map param){
        DungeonRuleModel ruleModel = (DungeonRuleModel)param.get("dungeonRule");
        String sql = "select from dungeon_rule_relation drr join dungeon_rule dr on (drr.rule_id = dr.id) ";
    }

}
