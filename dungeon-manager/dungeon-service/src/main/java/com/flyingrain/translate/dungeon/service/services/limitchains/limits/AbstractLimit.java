package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wally on 11/2/17.
 */
public abstract class AbstractLimit<T> implements Limit {

    private Logger logger = LoggerFactory.getLogger(AbstractLimit.class);

    final T limitModel;

    public AbstractLimit(String param) {
        limitModel = ObjectUtil.jsonToObject(param, getLimitClass());
    }

    public AbstractLimit(T limitModel) {
        this.limitModel = limitModel;
    }
    /**
     * 获取限制类
     *
     * @return
     */
    public abstract Class<T> getLimitClass();


}
