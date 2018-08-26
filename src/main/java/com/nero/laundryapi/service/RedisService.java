package com.nero.laundryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private final RedisTemplate redisTemplate;

    @Autowired
    private final RedisMessagePublisher redisMessagePublisher;

    @Autowired
    private final RedisMessageSubscriber redisMessageSubscriber;

    public RedisService(RedisTemplate redisTemplate, RedisMessagePublisher redisMessagePublisher, RedisMessageSubscriber redisMessageSubscriber) {
        this.redisTemplate = redisTemplate;
        this.redisMessagePublisher = redisMessagePublisher;
        this.redisMessageSubscriber = redisMessageSubscriber;
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void publish(Object message) {
        redisMessagePublisher.publish(message);
    }

    public boolean isContains(String message) {
        return redisMessageSubscriber.messageList.get(0).contains(message);
    }
}
