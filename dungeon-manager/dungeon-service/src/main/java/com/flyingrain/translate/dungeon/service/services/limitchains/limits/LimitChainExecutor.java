package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wally on 10/30/17.
 */
public final class LimitChainExecutor {


    private LinkedList<Limit> limits = new LinkedList<>();

    private final List<Limit> preLimits;

    private final List<Limit> ruleLimits;

    private final List<Limit> postLimits;

    public LimitChainExecutor(List<Limit> preLimits, List<Limit> ruleLimits, List<Limit> postLimits) {
        this.preLimits = preLimits;
        this.ruleLimits = ruleLimits;
        this.postLimits = postLimits;
    }

    public LimitResult execute() {

        return LimitResult.success();
    }

}
