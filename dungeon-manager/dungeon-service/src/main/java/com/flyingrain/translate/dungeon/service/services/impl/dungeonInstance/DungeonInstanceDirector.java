package com.flyingrain.translate.dungeon.service.services.impl.dungeonInstance;

import com.flyingrain.translate.dungeon.api.domain.DungeonDomain;
import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.domain.DungeonLimit;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 副本实例导演类
 * Created by wally on 3/16/18.
 */
@Component
public class DungeonInstanceDirector {

    private Logger logger = LoggerFactory.getLogger(DungeonInstanceDirector.class);

    @Autowired
    private DungeonInstanceBuilder dungeonInstanceBuilder;

    /**
     * 根据实例Id构建副本模型
     *
     * @param dungeonInstanceId
     * @return
     */
    public DungeonInstance build(int dungeonInstanceId) {
        logger.info("start to build dungeonInstance by id :[{}]", dungeonInstanceId);
        DungeonInstanceModel instanceModel = dungeonInstanceBuilder.dungeonInstance(dungeonInstanceId);
        logger.info("get dungeonInstanceModel :[{}]",instanceModel);
        List<DungeonLimit> limits = dungeonInstanceBuilder.dungeonLimits(instanceModel.getDungeon_source());
        DungeonResourceModel resourceModel = dungeonInstanceBuilder.dungeonModel(instanceModel.getDungeon_source());
        return generateInstance(limits, resourceModel, instanceModel);
    }

    /**
     * 根据实例对象构建实例模型
     *
     * @param dungeonInstanceModel
     * @return
     */
    public DungeonInstance build(DungeonInstanceModel dungeonInstanceModel) {
        List<DungeonLimit> limits = dungeonInstanceBuilder.dungeonLimits(dungeonInstanceModel.getDungeon_source());
        DungeonResourceModel resourceModel = dungeonInstanceBuilder.dungeonModel(dungeonInstanceModel.getDungeon_source());
        return generateInstance(limits, resourceModel, dungeonInstanceModel);
    }

    /**
     * 生成副本内容
     *
     * @param limits
     * @param dungeonResourceModel
     * @param dungeonInstanceModel
     * @return
     */
    private DungeonInstance generateInstance(List<DungeonLimit> limits, DungeonResourceModel dungeonResourceModel, DungeonInstanceModel dungeonInstanceModel) {
        DungeonInstance dungeonInstance = new DungeonInstance();
        dungeonInstance.setDungeonId(dungeonInstanceModel.getId());
        dungeonInstance.setEnrollTime(dungeonInstanceModel.getEnroll_time());
        dungeonInstance.setStartTime(dungeonInstanceModel.getStart_time());
        dungeonInstance.setStatus(dungeonInstanceModel.getDungeon_status());
        dungeonInstance.setRemark(dungeonResourceModel.getDesc());
        //生成副本模型
        DungeonDomain dungeonDomain = new DungeonDomain();
        dungeonDomain.setDesc(dungeonResourceModel.getDesc());
        dungeonDomain.setId(dungeonResourceModel.getId() + "");
        dungeonDomain.setImgPaths(Arrays.asList(dungeonResourceModel.getImgs().split(",")));
        dungeonDomain.setTitle(dungeonResourceModel.getTitle());
        dungeonDomain.setLimits(limits);
        dungeonInstance.setDungeonDomain(dungeonDomain);
        dungeonInstance.setFinishTime(dungeonInstanceModel.getEnd_time());
        return dungeonInstance;
    }

}
