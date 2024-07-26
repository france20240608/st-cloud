package com.st.cloud.module.agent.controller;


import com.alicp.jetcache.CacheManager;
import com.st.cloud.common.core.CommonResult;
import com.st.cloud.framework.redis.config.RedisUtil;
import com.st.cloud.module.agent.api.UserApi;
import com.st.cloud.module.agent.mq.RocketMQProducerService;
import com.st.cloud.module.agent.pojo.dto.MemberUserDTO;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;


@RestController
@RequestMapping(API_PREFIX + "/test")
@Slf4j
public class MemberUserController {

    @Value("${spring.application.name:aaaa}")
    private String aaaa;

    @Resource
    private UserApi userApi;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RocketMQProducerService rocketMQProducerService;

    @PostMapping("/testFeign")
    public CommonResult<MemberUserDO> testFeign(@RequestBody MemberUserDTO dto) {
        log.info("===============> {}", aaaa);
        // feign调用其他服务
        return userApi.getUserByUserId(dto);
    }

    @GetMapping("/testRedisSet")
    public String testRedisSet() {
        redisUtil.set("aaaa", System.currentTimeMillis(), 10L, TimeUnit.SECONDS);
        return redisUtil.getString("aaaa");
    }

    @GetMapping("/testRedisGet")
    public String testRedisGet() {
        return redisUtil.getString("aaaa");
    }

    @GetMapping("/testSendRocketMqMsg")
    public String testSendRocketMqMsg() {
        // sendDefaultImpl call timeout
        rocketMQProducerService.sendMessage("TopicTest", "1111111111");
        return "Message sent!";
    }
}
