package com.st.cloud.module.agent.api;

import com.st.cloud.module.agent.pojo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "st-module-service-user")
public interface UserApi {

    @PostMapping("/user/getUserByUserId")
    String getUserByUserId(@RequestBody UserVo userVo);
}
