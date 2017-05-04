package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.PlanGeneratorResource;
import com.flyingrain.translate.plan.api.response.Result;
import org.springframework.stereotype.Component;


/**
 * Created by wally on 4/26/17.
 */

@Component
@Resource
public class PlanGeneratorResourceImpl implements PlanGeneratorResource{
    @Override
    public Result<String> generate() {
        return null;
    }
}
