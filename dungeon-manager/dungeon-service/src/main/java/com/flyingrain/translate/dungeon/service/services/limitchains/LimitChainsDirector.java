package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitChainExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.WeakHashMap;

/**
 * Created on 18-3-24.
 *
 * @author wally
 */

@Component
public class LimitChainsDirector {

    private Logger logger = LoggerFactory.getLogger(LimitChainsDirector.class);

    private WeakHashMap<Integer, LimitChainExecutor> limitChainCache = new WeakHashMap<>();

    @Autowired
    private LimitChainsBuilder limitChainBuilder;

    public LimitChainExecutor buildChain(LimitChainRequest limitChainRequest) {
        logger.info("joinRequest:[{}]", limitChainRequest);
        LimitChainExecutor executor = limitChainCache.get(limitChainRequest.getInstanceModel().getDungeon_source());
        if (executor != null) {
            logger.info("there is cache,return cached chain!");
            return executor;
        }
        LimitContext.put(LimitConstant.PARAM,limitChainRequest);
        executor = new LimitChainExecutor(limitChainBuilder.buildPreChain(), limitChainBuilder.buildRuleChain(), limitChainBuilder.buildPostChain());
        logger.info("build limitChains success!start to cache it: dungeonId:[{}]", limitChainRequest.getInstanceModel().getDungeon_source());
        limitChainCache.put(limitChainRequest.getInstanceModel().getDungeon_source(), executor);
        return executor;
    }



}
