package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.domain.DungeonLimit;
import com.flyingrain.translate.dungeon.api.domain.DungeonStatus;
import com.flyingrain.translate.dungeon.api.domain.UserDungeonStatus;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.DungeonPlanResult;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.service.services.DungeonService;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.*;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceContainerModel;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.impl.dungeonInstance.DungeonInstanceDirector;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitChainBuilder;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
    private DungeonInstanceMapper dungeonInstanceMapper;

    @Autowired
    private DungeonInstanceDirector dungeonInstanceDirector;


    @Autowired
    private DungeonInstanceContainerMapper instanceContainerMapper;


    @Override
    public DungeonInstance getInstanceById(Integer dungeonInstanceId) {
        return dungeonInstanceDirector.build(dungeonInstanceId);
    }

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
        return dungeonIds.stream().flatMap(dungeonId -> dungeonInstanceMapper.dungeonInstanceByModelId(dungeonId, DungeonStatus.PREPARE.getStatus()).stream()).map(dungeonInstanceDirector::build).collect(Collectors.toList());
    }


    @Override
    public JoinResult joinDungeon(JoinRequest request) {
        logger.info("get join request :[{}]", request);
        LimitResult result = builder.build(request).execute();
        logger.info("result is [{}]", result);
        return result.isSuccess() ? userJoinDungeon(request) : new JoinResult(result.isSuccess(), request.getDungeonInstanceId(), result.getReason());
    }

    @Override
    public DungeonPlanResult dungeonPlan(Integer userId, Integer planId) {
        DungeonInstanceContainerModel containerModel = instanceContainerMapper.queryPlanStatus(userId, planId);
        DungeonPlanResult dungeonPlanResult = new DungeonPlanResult();
        dungeonPlanResult.setDesc(containerModel.getRemark());
        dungeonPlanResult.setStatus(containerModel.getStatus());
        dungeonPlanResult.setPlanId(planId);
        dungeonPlanResult.setDungeonInstanceId(containerModel.getDungeon_instance_id());
        return dungeonPlanResult;
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
