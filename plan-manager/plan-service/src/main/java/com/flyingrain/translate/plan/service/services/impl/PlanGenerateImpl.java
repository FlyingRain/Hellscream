package com.flyingrain.translate.plan.service.services.impl;

import com.flyingrain.translate.plan.api.request.PlanRequest;
import com.flyingrain.translate.plan.service.services.PlanGenerator;
import com.flyingrain.translate.plan.service.services.common.PlanStatus;
import com.flyingrain.translate.plan.service.services.dao.model.PlanModel;
import com.flyingrain.translate.words.collection.api.BookQuery;
import com.flyingrain.translate.words.collection.result.Book;
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
        PlanModel planModel = new PlanModel();
        Book book = bookQuery.getBook(planRequest.getBookId());
        planModel.setAll_word_number(book.getWordNumber());
        planModel.setBook_id(planRequest.getBookId());
        planModel.setDeadline(planRequest.getDeadline());
        planModel.setWord_number(planRequest.getNumber());
        planModel.setUser_id(planRequest.getUserId());
        planModel.setPlan_type(planRequest.getPlanType());
        planModel.setStatus(PlanStatus.UNDERWAY.status);

        return null;
    }
}
