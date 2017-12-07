package com.flyingrain.translate.dungeon.service.services.impl;

import com.flyingrain.translate.dungeon.api.domain.DungeonInstance;
import com.flyingrain.translate.dungeon.api.domain.UserDungeonStatus;
import com.flyingrain.translate.dungeon.api.requests.DungeonQueryRequest;
import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.api.responses.JoinResult;
import com.flyingrain.translate.dungeon.service.services.DungeonService;
import com.flyingrain.translate.dungeon.service.services.dao.mapper.DungeonInstanceContainerMapper;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonInstanceContainerModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitChainBuilder;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<DungeonInstance> getDungeons(DungeonQueryRequest queryRequest) {
        return null;
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
