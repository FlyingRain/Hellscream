package com.flyingrain.translate.database.conf.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by wally on 7/26/17.
 */
@Component
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations listOperations;

    @PostConstruct
    public void init(){
        //测试普通的key-value
        stringRedisTemplate.opsForValue().set("wulei","helloWord!");
        String value = stringRedisTemplate.opsForValue().get("wulei");
        //测试对象
        RedisModel model = new RedisModel("wulei","18");
        redisTemplate.opsForValue().set("redisModel",model);
        //测试散列
        redisTemplate.opsForHash().put("11","age","18");

    }
}
