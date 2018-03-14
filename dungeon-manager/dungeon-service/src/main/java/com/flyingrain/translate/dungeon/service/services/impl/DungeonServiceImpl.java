package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.api.domain.*;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.service.services.DungeonService;
import com.flyingrain.translate.dungeon.service.services.common.ActiveEnum;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.*;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceContainerModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonResourceModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitChainBuilder;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wally on 10/26/17.
 */
@Component
public class DungeonServiceImpl implements DungeonService {

    private Logger logger = LoggerFactory.getLogger(DungeonServiceImpl.class);
    @Autowired
    private LimitChainBuilder builder;

    @Autowired
    private DungeonInstanceContainerMapper containerMapper;

    @Autowired
    private DungeonRuleRelationMapper dungeonRuleRelationMapper;

    @Autowired
    private DungeonResourceMapper resourceMapper;

    @Autowired
    private DungeonInstanceMapper dungeonInstanceMapper;

    @Autowired
    private DungeonRuleMapper dungeonRuleMapper;


    @Override
    public List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest) {
        //TODO 目前只支持单条件查询
        List<DungeonLimit> limits = queryRequest.getLimits();
        DungeonRuleModel dungeonRuleModel = new DungeonRuleModel();
        if (CollectionUtils.isEmpty(limits)) {
            dungeonRuleModel = null;
        } else {
            DungeonLimit limit = limits.get(0);
            dungeonRuleModel.setRule_param(limit.getValue());
            dungeonRuleModel.setRule_type(limit.getType());
        }
        List<Integer> dungeonIds = dungeonRuleRelationMapper.queryDungeonByRule(dungeonRuleModel);
        List<DungeonInstance> dungeonInstances = new ArrayList<>();

        dungeonIds.stream().map(resourceMapper::getByDungeonId).forEach(dungeonResource -> {
            List<DungeonInstanceModel> instanceModels = dungeonInstanceMapper.dungeonInstanceByModelId(dungeonResource.getId(), DungeonStatus.PREPARE.getStatus());
            List<DungeonRuleModel> ruleModels = dungeonRuleMapper.getRulesByDungeonId(dungeonResource.getId(), ActiveEnum.ACTIVE.ordinal());
            instanceModels.forEach(instanceModel -> dungeonInstances.add(generateInstance(ruleModels, dungeonResource, instanceModel)));
        });
        return dungeonInstances;
    }

    /**
     * 生成副本内容
     *
     * @param ruleModels
     * @param dungeonResourceModel
     * @param dungeonInstanceModel
     * @return
     */
    private DungeonInstance generateInstance(List<DungeonRuleModel> ruleModels, DungeonResourceModel dungeonResourceModel, DungeonInstanceModel dungeonInstanceModel) {
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
        dungeonDomain.setLimits(ruleModels.stream().map(model -> {
            DungeonLimit limit = new DungeonLimit();
            limit.setDesc(model.getRule());
            limit.setType(model.getRule_type());
            limit.setValue(model.getRule_param());
            return limit;
        }).collect(Collectors.toList()));
        dungeonInstance.setDungeonDomain(dungeonDomain);
        dungeonInstance.setFinishTime(dungeonInstanceModel.getEnd_time());
        return dungeonInstance;
    }

    @Override
    public JoinResult joinDungeon(JoinRequest request) {
        logger.info("get join request :[{}]", request);
        LimitResult result = builder.build(request).execute();
        logger.info("result is [{}]", result);
        return result.isSuccess() ? userJoinDungeon(request) : new JoinResult(result.isSuccess(), request.getDungeonInstanceId(), result.getReason());
    }

    /**
     * 用户加入副本
     *
     * @param joinRequest
     * @return
     */
    private JoinResult userJoinDungeon(JoinRequest joinRequest) {
        logger.info("start to insert database:[{}]", joinRequest);
        int i = containerMapper.userJoinDungeon(new DungeonInstanceContainerModel(joinRequest.getDungeonInstanceId(), joinRequest.getPlanId(), joinRequest.getUserId(), UserDungeonStatus.PREPAREUNPAY.getStatus(), StringUtils.EMPTY));
        return i == 1 ? new JoinResult(true, joinRequest.getDungeonInstanceId(), StringUtils.EMPTY) : new JoinResult(false, joinRequest.getDungeonInstanceId(), "加入失败");
    }
}
