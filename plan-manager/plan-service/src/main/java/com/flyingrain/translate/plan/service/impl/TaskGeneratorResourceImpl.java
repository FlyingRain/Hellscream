package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.TaskGeneratorResource;
import com.flyingrain.translate.plan.api.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by wally on 4/26/17.
 */

@Component
@Resource
public class TaskGeneratorResourceImpl implements TaskGeneratorResource {

    private Logger logger = LoggerFactory.getLogger(TaskGeneratorResourceImpl.class);

    @Override
    public Result<String> generate() {

        return null;
    }
}
