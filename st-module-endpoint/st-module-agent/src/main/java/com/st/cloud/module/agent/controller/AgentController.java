package com.st.cloud.module.agent.controller;


import com.st.cloud.module.agent.api.UserApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent/user")
@Slf4j
public class AgentController {

    @Value("${aaaa:aaaa}")
    private String aaaa;

    @Resource
    private UserApi userApi;

    @GetMapping("/list")
    public String list() {
        log.info("===============> {}", aaaa);
        return userApi.userList();
    }
}
