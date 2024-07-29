package com.st.cloud.agent.controller.user;

import com.st.cloud.agent.core.Constant;
import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_PREFIX + "/user")
public class SystemUserController {

    @Resource
    private SystemUserService systemUserService;

    @PostMapping("/getByUsername")
    public CommonResult<MemberUserRespDTO> getByUsername(String username) {
        return systemUserService.getByUsername(username);
    }
}
