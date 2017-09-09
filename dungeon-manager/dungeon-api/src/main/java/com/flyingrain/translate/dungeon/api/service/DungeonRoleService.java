package com.flyingrain.translate.dungeon.api.service;

import com.flyingrain.translate.dungeon.api.domain.DungeonRole;

/**
 * Created by Uni on 2017/9/9.
 */
public interface DungeonRoleService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    DungeonRole getRole(int id);
}
