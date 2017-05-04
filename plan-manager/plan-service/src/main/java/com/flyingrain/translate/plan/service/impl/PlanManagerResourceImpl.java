package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.PlanManagerResource;
import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.api.response.ModifyResult;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.Result;
import com.flyingrain.translate.plan.api.response.ResultType;
import com.flyingrain.translate.plan.service.services.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wally on 4/25/17.
 */
@Component
@Resource
public class PlanManagerResourceImpl implements PlanManagerResource {

    private Logger logger = LoggerFactory.getLogger(PlanManagerResourceImpl.class);
    @Autowired
    private PlanService planService;

    @Override
    public Result<Integer> makePlan(PlanRequest planRequest) {
        logger.info("get make plan request : [{}]", planRequest);
        Result<Integer> result = new Result<>();
        Integer planId = planService.makePlan(planRequest);
        if (planId == null) {
            result.setCode(ResultType.FAIL.code);
            result.setMsg(ResultType.FAIL.desc);
        } else {
            result.setMsg(ResultType.SUCCESS.desc);
            result.setCode(ResultType.SUCCESS.code);
            result.setRealResult(planId);
        }
        return result;
    }

    @Override
    public Result<List<Plan>> queryPlan(Integer planId, Integer userId) {
        Result<List<Plan>> result = new Result<>();
        //参数校验
        if(planId==null&&userId==null){
            logger.info("query param is null!");
            result.setCode(ResultType.FAIL_PARAM_INVALID.code);
            result.setMsg(ResultType.FAIL_PARAM_INVALID.desc);
            return result;
        }
        List<Plan> realResult = planService.queryPlan(planId,userId);
        result.setCode(ResultType.SUCCESS.code);
        result.setMsg(ResultType.SUCCESS.desc);
        result.setRealResult(realResult);
        return result;
    }

    @Override
    public Result<ModifyResult> modifyPlan(PlanRequest planRequest) {
        logger.info("start to update planRequest![{}]",planRequest);
        int i = planService.modifyPlan(planRequest);
        Result<ModifyResult> result = new Result<>();
        if(i==0){
            result.setCode(ResultType.FAIL.code);
            result.setMsg(ResultType.FAIL.desc);
            return result;
        }
        ModifyResult modifyResult = new ModifyResult();
        modifyResult.setMsg("更新成功");
        modifyResult.setStatus("00");
        result.setRealResult(modifyResult);
        result.setCode(ResultType.SUCCESS.code);
        result.setMsg(ResultType.SUCCESS.desc);
        return result;
    }
}
