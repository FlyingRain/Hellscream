package com.flyingrain.translate.auth.service.services.dao.redis.subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by wally on 17-8-3.
 */

@Component
public class TopicMessageListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(TopicMessageListener.class);
    /**
     * 全局锁，用来解决集群重复处理订阅消息的情况
     */
    private static final String LOCK = "task-job-lock";
    /**
     * key
     */
    private static final String KEY = "tasklock";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {// 客户端监听订阅的topic，当有消息的时候，会触发该方法
        boolean lock = false;
        try {
            // 获取锁
            lock = stringRedisTemplate.opsForValue().setIfAbsent(KEY, LOCK);
            if (lock) {
                // 如果在执行任务的过程中，程序突然挂了，为了避免程序因为中断而造成一直加锁的情况产生，20分钟后，key值失效，自动释放锁，
                stringRedisTemplate.expire(KEY, 200, TimeUnit.MILLISECONDS);
                byte[] body = message.getBody();// 请使用valueSerializer
                byte[] channel = message.getChannel();
                String topic = new String(channel);
                String itemValue = new String(body);
                // 请参考配置文件，本例中key，value的序列化方式均为string。
                logger.info("topic:" + topic);
                logger.info("itemValue:" + itemValue);
            } else {
                System.out.println("没有获取到锁，不执行任务!");
                logger.info("can't get lock!");
                return;
            }
        } finally {// 无论如何，最终都要释放锁
            if (lock) {// 如果获取了锁，则释放锁
                stringRedisTemplate.delete(KEY);
                logger.info("任务结束，释放锁!");
            } else {
                logger.info("没有获取到锁，无需释放锁!");
            }
        }
    }
}
