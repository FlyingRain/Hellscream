package com.flyingrain.translate.dungeon.service.services;

import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;

/**
 * Created by Uni on 2017/9/11.
 */
public interface DungeonResourceService {

    /**
     * 根据id查找
     * @param id
     * @return
     */
    DungeonResourceModel getResource(int id);

    /**
     * 删除对应的resource
     * @param id
     * @return
     */
    int deleteResource(int id);
}
