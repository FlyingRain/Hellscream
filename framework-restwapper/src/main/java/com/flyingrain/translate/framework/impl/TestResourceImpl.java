package com.flyingrain.translate.framework.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.api.TestResource;
import org.springframework.stereotype.Component;

/**
 * Created by wally on 4/5/17.
 */
@Component
@Resource
public class TestResourceImpl implements TestResource {
    @Override
    public String getTest() {
        return "success!";
    }
}
