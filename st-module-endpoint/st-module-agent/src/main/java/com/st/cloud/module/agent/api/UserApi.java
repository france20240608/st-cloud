package com.st.cloud.module.agent.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "st-module-service-user")
public interface UserApi {

    @GetMapping("/user/list")
    String userList();
}
