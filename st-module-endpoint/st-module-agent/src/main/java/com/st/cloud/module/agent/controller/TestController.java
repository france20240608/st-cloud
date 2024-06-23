package com.st.cloud.module.agent.controller;


import com.alicp.jetcache.CacheManager;
import com.st.cloud.module.agent.api.UserApi;
import com.st.cloud.module.agent.service.RocketMQProducerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Value("${spring.application.name:aaaa}")
    private String aaaa;

    @Resource
    private UserApi userApi;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/testFeign")
    public String testFeign() {
        log.info("===============> {}", aaaa);
        // feign调用其他服务
        return userApi.userList();
    }

    @GetMapping("/testRedisSet")
    public String testRedisSet() {
        redisTemplate.opsForValue().set("aaaa","bbbbb");
        return (String) redisTemplate.opsForValue().getAndExpire("aaaa", 10L, TimeUnit.SECONDS);
    }

    @GetMapping("/testRedisGet")
    public String testRedisGet() {
        return (String) redisTemplate.opsForValue().get("aaaa");
    }

    @GetMapping("/testRocketMq")
    public String testRocketMq() {

        return "";
    }

    @Autowired
    private RocketMQProducerService producerService;

    @GetMapping("/testSendRocketMqMsg")
    public String testSendRocketMqMsg() {
        // sendDefaultImpl call timeout
        producerService.sendMessage("TopicTest", "1111111111");
        return "Message sent!";
    }
}
