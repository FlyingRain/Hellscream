package com.flyingrain.translate.dungeon.service.services.limitchains;

import com.flyingrain.translate.dungeon.api.requests.JoinRequest;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.LimitChainExecutor;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.intf.TaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 10/26/17.
 */
@Component
public class LimitChainBuilder {


    @Autowired
    private PlanManagerResource planManagerResource;

    @Autowired
    private TaskResource taskResource;
    /**
     * 根据加入副本请求构建判断
     *
     * @param joinRequest
     * @return
     */
    public LimitChainExecutor build(JoinRequest joinRequest) {
        return null;
    }

}
