package com.st.cloud.module.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Value("${server.port:11111}")
    private String port;

    @SentinelResource(value = "user-list", blockHandler = "blockHandlerForUser")
    @GetMapping("/list")
    public String list() {
        // 从nacos获取配置
        log.info("===============> {}", System.currentTimeMillis());
        // 查看feign调用是不是负载到从nacos注册中心获取的不同节点
        return port;
    }

    public String blockHandlerForUser(BlockException ex) {
        log.info("===============> {}", "user-list is blocked");
        return "user-list is blocked";
    }
}
