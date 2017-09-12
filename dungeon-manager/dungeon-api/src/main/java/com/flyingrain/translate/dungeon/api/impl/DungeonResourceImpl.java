package com.flyingrain.translate.dungeon.api.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonResource;
import com.flyingrain.translate.dungeon.api.mapper.DungeonResourceMapper;
import com.flyingrain.translate.dungeon.api.service.DungeonResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/9.
 */
@Component
public class DungeonResourceImpl implements DungeonResourceService {

    @Autowired
    private DungeonResourceMapper dungeonResourceMapper;

    @Override
    public DungeonResource getResource(int id) {
        return dungeonResourceMapper.getResource(id);
    }

    @Override
    public int deleteResource(int id) {
        return dungeonResourceMapper.deleteResource(id);
    }
}