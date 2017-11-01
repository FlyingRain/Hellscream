package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.common.LimitEnum;
import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.BookTypeLimitModel;
import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import com.flyingrain.translate.plan.api.response.Plan;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by wally on 10/31/17.
 */
public class BookTypeLimit implements Limit{

    private Logger logger = LoggerFactory.getLogger(BookTypeLimit.class);
    @Override
    public LimitResult determine(Map<String, String> limits, Plan plan) {
        LimitResult result = new LimitResult();
        String limitString = limits.get(LimitEnum.WORDTYPE.getLimitName());
        if(StringUtils.isEmpty(limitString)){
            logger.warn("wordLimit is null!don't check it.");
            result.setSuccess(true);
            return result;
        }
        BookTypeLimitModel bookTypeLimitModel = ObjectUtil.jsonToObject(limitString,BookTypeLimitModel.class);


        return null;
    }
}
