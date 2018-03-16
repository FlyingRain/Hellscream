package com.flyingrain.translate.dungeon.service.services.impl.dungeonInstance;

import com.flyingrain.translate.dungeon.api.domain.DungeonLimit;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;

import java.util.List;

/**
 * 副本实例构建器
 * Created by wally on 3/16/18.
 */
public interface DungeonInstanceBuilder {

    /**
     * 获取副本模板限制
     * @param dungeonModelId
     * @return
     */
    List<DungeonLimit> dungeonLimits(int dungeonModelId);


    /**
     * 获取副本模板
     * @param dungeonModelId
     * @return
     */
    DungeonResourceModel dungeonModel(int dungeonModelId);


    /**
     * 获取副本实例
     * @param dungeonInstanceId
     * @return
     */
    DungeonInstanceModel dungeonInstance(int dungeonInstanceId);

}
