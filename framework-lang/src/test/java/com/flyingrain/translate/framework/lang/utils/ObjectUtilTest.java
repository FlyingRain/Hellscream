package com.flyingrain.translate.framework.lang.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ObjectUtilTest {

    private LinkedHashMap map = new LinkedHashMap();

    @Before
    public void prepare(){
        LinkedHashMap testModel = new LinkedHashMap();
        testModel.put("id","1");
        testModel.put("name","testModel1");
        List models = new ArrayList();
        LinkedHashMap testModel1 = new LinkedHashMap();
        testModel1.put("id","2");
        testModel1.put("name","testModel2");
        LinkedHashMap testModel2 = new LinkedHashMap();
        testModel2.put("id","3");
        testModel2.put("name","testModel3");
        models.add(testModel1);
        models.add(testModel2);
        map.put("id","1");
        map.put("model",testModel);
        map.put("models",models);
    }


    @Test
    public void testMap(){
        TestList testList = ObjectUtil.mapToObject(map,TestList.class);
    }
}
