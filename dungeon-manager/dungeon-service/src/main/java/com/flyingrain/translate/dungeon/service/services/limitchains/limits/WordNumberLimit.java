package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.WordNumberLimitModel;
import com.flyingrain.translate.plan.api.response.Plan;
import com.flyingrain.translate.plan.api.response.TaskSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 11/2/17.
 */
@Component
public class WordNumberLimit extends AbstractLimit<WordNumberLimitModel> {

    private Logger logger = LoggerFactory.getLogger(WordNumberLimit.class);

    @Override
    public int getLimitName() {
        return LimitEnum.WORDNUMBER.getLimitName();
    }

    @Override
    public Class<WordNumberLimitModel> getLimitClass() {
        return WordNumberLimitModel.class;
    }

    @Override
    public LimitResult judge(WordNumberLimitModel limitObject, Plan plan, TaskSummary summary) {
        if (limitObject == null) {
            logger.info("limit is null,judge pass!");
            return LimitResult.success();
        }
        //按单词数量
        int large = limitObject.getLargest() == 0 ? Integer.MAX_VALUE : limitObject.getLargest();
        int least = limitObject.getLeast();
        if (summary.getNewWordsNumber() >= least && summary.getNewWordsNumber() <= large) {
            return LimitResult.success();
        } else {
            return LimitResult.fail("单词数量不符合要求;");
        }
    }
}
