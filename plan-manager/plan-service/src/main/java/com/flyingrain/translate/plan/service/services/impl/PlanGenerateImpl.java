package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.service.services.PlanGenerator;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.words.collection.api.BookQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 6/19/17.
 */
@Component
class PlanGenerateImpl implements PlanGenerator {

    @Autowired
    private BookQuery bookQuery;
    @Override
    public PlanModel generatePlan(PlanRequest planRequest) {

        return null;
    }
}
