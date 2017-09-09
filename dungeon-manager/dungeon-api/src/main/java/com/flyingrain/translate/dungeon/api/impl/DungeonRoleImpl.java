package com.flyingrain.translate.dungeon.api.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonRole;
import com.flyingrain.translate.dungeon.api.mapper.DungeonRoleMapper;
import com.flyingrain.translate.dungeon.api.service.DungeonRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/9.
 */
@Component
public class DungeonRoleImpl implements DungeonRoleService {

    @Autowired
    private DungeonRoleMapper dungeonRoleMapper;

    @Override
    public DungeonRole getRole(int id) {
        return dungeonRoleMapper.getRole(id);
    }
}
