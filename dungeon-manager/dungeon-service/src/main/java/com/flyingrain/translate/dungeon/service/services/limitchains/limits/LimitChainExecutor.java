package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

/**
 * Created by wally on 10/30/17.
 */
public class LimitChainExecutor {


    private LinkedList<Limit> limits = new LinkedList<>();
    private final Map<Integer, Optional<String>> details;
    private final Plan plan;
    private final TaskSummary taskSummary;

    public LimitChainExecutor(Map<Integer, Optional<String>> details, Plan plan, TaskSummary taskSummary,LinkedList<Limit> limits) {
        this.details = details;
        this.plan = plan;
        this.taskSummary = taskSummary;
        this.limits = limits;
    }

    public LimitResult execute() {
        if (!CollectionUtils.isEmpty(limits))
            return limits.stream().map(limit -> limit.determine(details, plan, taskSummary)).reduce((l, r) -> {
                l.setSuccess(l.isSuccess() && r.isSuccess());
                l.setReason(l.getReason() + ";" + r.getReason());
                return l;
            }).get();
        else
            return LimitResult.success();
    }

    public LinkedList<Limit> getLimits() {
        return limits;
    }

    public void setLimits(LinkedList<Limit> limits) {
        this.limits = limits;
    }
}
