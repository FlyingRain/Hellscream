package com.flyingrain.translate.framework.impl;

import com.flyingrain.translate.framework.annotaions.Resource;
import com.flyingrain.translate.framework.api.TestResource;
import com.flyingrain.translate.framework.api.TestResourceProxy;
import com.flyingrain.translate.framework.api.param.MyParam;
import com.flyingrain.translate.framework.api.param.MyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wally on 4/5/17.
 */
@Component
@Resource
public class TestResourceImpl implements TestResourceProxy {
    Logger logger = LoggerFactory.getLogger(TestResource.class);

    @Autowired
    private TestResource resource;

    @Override
    public MyResult testProxy() {
        return resource.testPost(new MyParam("asd", "asffasd"));
    }

    @Override
    public MyResult testWebTarget(MyParam a) {
        List<String> ll = new ArrayList<>();
        ll.add("adfa");
        MyResult myResult = new MyResult();
        myResult.setA("result");
        myResult.setIds(ll);
        return myResult;
    }

    @Override
    public String testCommon(Date date) {
        return "common response!";
    }
}
