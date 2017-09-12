package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.service.services.DungeonResourceService;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonResourceMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Uni on 2017/9/11.
 */
@Component
public class DungeonResourceImpl implements DungeonResourceService {

    @Autowired
    private DungeonResourceMapper dungeonResourceMapper;

    @Override
    public DungeonResourceModel getResource(int id) {
        return dungeonResourceMapper.getByDungeonId(id);
    }

    @Override
    public int deleteResource(int id) {
        return dungeonResourceMapper.deleteResourceById(id);
    }
}
