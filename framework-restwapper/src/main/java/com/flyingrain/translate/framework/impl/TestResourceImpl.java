package com.flyingrain.translate.framework.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.api.TestResource;
import com.flyingrain.translate.framework.api.TestResourceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/5/17.
 */
@Component
@Resource
public class TestResourceImpl implements TestResourceProxy {
    Logger logger = LoggerFactory.getLogger(TestResource.class);

    @Autowired
    TestResource testResource;

    @Override
    public String testProxy() {
        testResource.testPost("asdfa");
        return null;
    }
}
