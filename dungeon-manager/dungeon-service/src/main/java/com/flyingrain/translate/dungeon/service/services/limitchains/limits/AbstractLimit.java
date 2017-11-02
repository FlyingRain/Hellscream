package com.flyingrain.translate.dungeon.service.services.limitchains.limits;

import com.flyingrain.translate.framework.lang.utils.ObjectUtil;
import com.flyingrain.translate.plan.api.response.Plan;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by wally on 11/2/17.
 */
public abstract class AbstractLimit<T> implements Limit{

    private Logger logger = LoggerFactory.getLogger(AbstractLimit.class);
    @Override
    public LimitResult determine(Map<String, String> limits, Plan plan) {
        String limitString = limits.get(getLimitName());
        if(StringUtils.isEmpty(limitString)){
            logger.warn("there is no limit :[{}]",getLimitName());
            return LimitResult.success();
        }
        T limitObject = ObjectUtil.jsonToObject(limitString,getLimitClass());
        return judge(limitObject,plan);
    }

    /**
     * 获取限制名称
     * @return
     */
    public abstract String getLimitName();

    /**
     * 获取限制类
     * @return
     */
    public abstract Class<T> getLimitClass();

    /**
     * 判断是否符合
     * @param limitObject
     * @param plan
     * @return
     */
    public abstract LimitResult judge(T limitObject,Plan plan);
}
