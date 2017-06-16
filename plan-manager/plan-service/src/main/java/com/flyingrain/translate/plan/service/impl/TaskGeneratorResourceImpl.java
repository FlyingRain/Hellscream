package com.flyingrain.translate.plan.service.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.plan.api.intf.TaskGeneratorResource;
import com.flyingrain.translate.plan.api.response.Result;
import com.flyingrain.translate.plan.service.services.TaskGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by wally on 4/26/17.
 */

@Component
@Resource
public class TaskGeneratorResourceImpl implements TaskGeneratorResource {

    private Logger logger = LoggerFactory.getLogger(TaskGeneratorResourceImpl.class);
    @Autowired
    private TaskGenerator taskGenerator;

    @Override
    public String generate() {
        taskGenerator.generateTasks();
        logger.info("complete generate!");
        return "generate success!";
    }
}
