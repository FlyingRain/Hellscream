package com.flyingrain.translate.framework.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.api.TestResource;
import com.flyingrain.translate.framework.api.TestResourceProxy;
import com.flyingrain.translate.framework.lang.FlyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/5/17.
 */
@Component
@Resource
public class TestResourceImpl implements TestResourceProxy {
    Logger logger = LoggerFactory.getLogger(TestResource.class);


    @Override
    public String testProxy() {
        throw new FlyException("asdf", "我的异常");
    }
}
