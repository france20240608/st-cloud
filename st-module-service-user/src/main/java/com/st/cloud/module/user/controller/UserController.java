package com.st.cloud.module.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.st.cloud.module.user.entity.bo.User;
import com.st.cloud.module.user.service.UserService;
import jakarta.annotation.Resource;
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
    @Resource
    public UserService userService;

    @SentinelResource(value = "user-port", blockHandler = "blockHandlerForUser")
    @GetMapping("/port")
    public String port() {
        // 从nacos获取配置
        log.info("===============> {}", System.currentTimeMillis());
        // 查看feign调用是不是负载到从nacos注册中心获取的不同节点
        return port;
    }

    @SentinelResource(value = "user-list", blockHandler = "blockHandlerForUser")
    @GetMapping("/list")
    public User list() {
        // 从nacos获取配置
        log.info("===============> {}", System.currentTimeMillis());
        User user = userService.getUserByUserId(1L);
        return user;
    }

    public String blockHandlerForUser(BlockException ex) {
        log.info("===============> {}", "user-list is blocked");
        return "user-list sentinel is blocked";
    }
}
