package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.WordNumberLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.PlanType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 11/2/17.
 */
public class WordNumberLimit extends AbstractLimit<WordNumberLimitModel> {

    private Logger logger = LoggerFactory.getLogger(WordNumberLimit.class);

    @Override
    public String getLimitName() {
        return LimitEnum.WORDNUMBER.getLimitName();
    }

    @Override
    public Class<WordNumberLimitModel> getLimitClass() {
        return WordNumberLimitModel.class;
    }

    @Override
    public LimitResult judge(WordNumberLimitModel limitObject, Plan plan) {
        if (limitObject == null) {
            logger.info("limit is null,judge pass!");
            return LimitResult.success();
        }
        //按单词数量
        if (plan.getPlanType() == PlanType.BYNUMBER.getType()) {
            int large = limitObject.getLargest() == 0 ? Integer.MAX_VALUE : limitObject.getLargest();
            int least = limitObject.getLeast();
            if (plan.getNumber() >= least && plan.getNumber() <= large) {
                return LimitResult.success();
            } else {
                return LimitResult.fail("单词数量不符合要求;");
            }
        }
        if (plan.getPlanType() == PlanType.BYDEADLINE.getType()) {

        }
        return null;
    }
}
