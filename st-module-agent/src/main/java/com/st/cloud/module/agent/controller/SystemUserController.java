package com.st.cloud.module.agent.controller;

import com.st.cloud.common.core.CommonResult;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import com.st.cloud.module.agent.service.MemberUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/user")
public class SystemUserController {

    @Resource
    private MemberUserService memberUserService;

    @PostMapping("/getByUsername")
    public CommonResult<MemberUserDO> getByUsername(String username) {
        MemberUserDO user = memberUserService.getByUsername(username);
        CommonResult<MemberUserDO> result = new CommonResult<>();
        result.setData(user);
        return result;
    }

    @PostMapping("/getByUsername1")
    public CommonResult<String> getByUsername1(String username) {
//        MemberUserDO user = memberUserService.getByUsername(username);
        CommonResult<String> result = new CommonResult<>();
        result.setData("11111111");
        return result;
    }
}
