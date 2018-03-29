package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

/**
 * 加入副本限制条件
 * Created by wally on 10/30/17.
 */
public interface Limit {

    /**
     * 决定是否符合
     * @return
     */
    LimitResult determine();

}