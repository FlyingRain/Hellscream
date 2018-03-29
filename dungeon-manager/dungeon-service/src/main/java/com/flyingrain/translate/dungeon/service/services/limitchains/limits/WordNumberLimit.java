package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitConstant;
import com.flyingrain.translate.dungeon.service.services.limitchains.LimitContext;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.WordNumberLimitModel;
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

    public WordNumberLimit(String param) {
        super(param);
    }

    public WordNumberLimit(WordNumberLimitModel limitModel) {
        super(limitModel);
    }

    @Override
    public Class<WordNumberLimitModel> getLimitClass() {
        return WordNumberLimitModel.class;
    }

    @Override
    public LimitResult determine() {
        if (limitModel == null) {
            logger.info("limit is null,judge pass!");
            return LimitResult.success();
        }
        //按单词数量
        int large = limitModel.getLargest() == 0 ? Integer.MAX_VALUE : limitModel.getLargest();
        int least = limitModel.getLeast();
        TaskSummary summary = (TaskSummary) LimitContext.get(LimitConstant.SUMMARY);
        if (summary.getNewWordsNumber() >= least && summary.getNewWordsNumber() <= large) {
            return LimitResult.success();
        } else {
            return LimitResult.fail("单词数量不符合要求;");
        }
    }
}
