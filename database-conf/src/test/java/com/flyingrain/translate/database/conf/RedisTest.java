package com.flyingrain.translate.database.conf;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wally on 7/26/17.
 */
@RunWith(SpringRunner.class)
@Import(RedisConfig.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("wulei","helloWord!");
        Assert.assertEquals("helloWord!",stringRedisTemplate.opsForValue().get("wulei"));
    }

}
