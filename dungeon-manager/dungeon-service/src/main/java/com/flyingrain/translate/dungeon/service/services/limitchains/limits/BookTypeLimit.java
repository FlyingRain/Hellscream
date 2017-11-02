package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.BookTypeLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 10/31/17.
 */
public class BookTypeLimit extends AbstractLimit<BookTypeLimitModel> {

    private Logger logger = LoggerFactory.getLogger(BookTypeLimit.class);


    @Override
    public String getLimitName() {
        return LimitEnum.WORDTYPE.getLimitName();
    }

    @Override
    public Class<BookTypeLimitModel> getLimitClass() {
        return BookTypeLimitModel.class;
    }

    @Override
    public LimitResult judge(BookTypeLimitModel limitObject, Plan plan) {
        if (limitObject == null||limitObject.getBookType() == plan.getBookId()) {
            logger.info("judge pass,limit :[{}]",limitObject);
            return LimitResult.success();
        }
        return LimitResult.fail("单词书类型不匹配;");
    }
}
