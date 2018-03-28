package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.service.services.dao.models.DungeonRuleModel;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.Limit;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 18-3-18.
 */
@Component
public class LimitChainsBuilderImpl implements LimitChainsBuilder{


    @Override
    public List<Limit> buildPreChain() {
        return null;
    }

    @Override
    public List<Limit> buildRuleChain() {
        return null;
    }

    @Override
    public List<Limit> buildPostChain() {
        return null;
    }
}
