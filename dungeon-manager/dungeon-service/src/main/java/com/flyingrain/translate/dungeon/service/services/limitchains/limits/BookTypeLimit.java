package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitContext;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.BookTypeLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 10/31/17.
 */
@LimitType("01")
public class BookTypeLimit extends AbstractLimit<BookTypeLimitModel> {

    private Logger logger = LoggerFactory.getLogger(BookTypeLimit.class);

    public BookTypeLimit(String param) {
        super(param);
    }

    public BookTypeLimit(BookTypeLimitModel limitModel) {
        super(limitModel);
    }

    @Override
    public Class<BookTypeLimitModel> getLimitClass() {
        return BookTypeLimitModel.class;
    }


    @Override
    public LimitResult determine() {
        Plan plan = (Plan) LimitContext.get(LimitConstant.PLAN);
        if (limitModel == null || limitModel.getBookType() == plan.getBookId()) {
            logger.info("judge pass,limit :[{}]", limitModel);
            return LimitResult.success();
        }
        return LimitResult.fail("单词书类型不匹配;");
    }
}
