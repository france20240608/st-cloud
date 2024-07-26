package com.st.cloud.module.agent.controller;

import com.st.cloud.common.core.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/role")
public class SystemRoleController {

    @PostMapping("/list")
    public CommonResult list(){
        return null;
    }
}
