package com.flyingrain.translate.framework.wrapper;

import com.flyingrain.translate.framework.api.TestResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 包装类测试
 * Created by wally on 6/8/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Config.class)
public class TestWrapper {
    @Autowired
    private TestResource testResource;


    @Test
    public void testWrapper() {

        String result = testResource.testPost("test");

    }

    @Test
    public void testGet() {
        String aa = testResource.getTest("oioo", "asdf");


    }

}
