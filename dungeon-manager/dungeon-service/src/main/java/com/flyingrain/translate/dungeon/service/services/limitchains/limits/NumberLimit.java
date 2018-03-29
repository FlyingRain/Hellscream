package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.dungeon.service.services.limitchains.limits.models.NumberLimitModel;

/**
 * Created by wally on 11/6/17.
 */
public class NumberLimit extends AbstractLimit<NumberLimitModel> {


    public NumberLimit(String param) {
        super(param);
    }

    public NumberLimit(NumberLimitModel limitModel) {
        super(limitModel);
    }

    @Override
    public Class<NumberLimitModel> getLimitClass() {
        return null;
    }


    @Override
    public LimitResult determine() {
        //TODO add number limit
        return LimitResult.success();
    }
}
