package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.service.services.limitchains.limits.Limit;

import java.util.List;

/**
 * 限制链构建
 * Created by wally on 18-3-17.
 */
public interface LimitChainsBuilder {


    /**
     * 构建前置校验
     *
     * @return
     */
    List<Limit> buildPreChain();

    /**
     * 构建规则处理
     *
     * @return
     */
    List<Limit> buildRuleChain();

    /**
     * 构建后置处理
     *
     * @return
     */
    List<Limit> buildPostChain();
}
