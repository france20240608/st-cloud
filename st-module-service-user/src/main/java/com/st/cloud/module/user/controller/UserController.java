package com.st.cloud.module.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Value("${aaaa:aaaa}")
    private String aaaa;
    @Value("${server.port:11111}")
    private String port;

    @GetMapping("/list")
    public String list() {
        log.info("===============> {}", aaaa);
        return port;
    }
}
