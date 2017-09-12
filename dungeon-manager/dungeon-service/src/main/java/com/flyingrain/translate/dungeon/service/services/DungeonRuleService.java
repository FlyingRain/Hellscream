package com.flyingrain.translate.dungeon.service.services;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;

/**
 * Created by Uni on 2017/9/11.
 */
public interface DungeonRuleService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    DungeonRuleModel getRule(int id);

    /**
     * 更新
     * @param id
     * @param isActive
     * @param range
     */
    int updateRule(int id, int isActive, String range);

    /**
     * 删除对应的role
     * @param id
     * @return
     */
    int deleteRule(int id);
}
