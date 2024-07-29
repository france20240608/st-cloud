package com.st.cloud.agent.controller.user;

import com.st.cloud.agent.core.Constant;
import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.pojo.CommonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_PREFIX + "/user")
public class SystemUserController {

    @Resource
    private SystemUserService systemUserService;

    @PostMapping("/getMemberByUsername")
    public CommonResult<MemberUserVO> getMemberByUsername(String username) {
        return systemUserService.getMemberByUsername(username);
    }

    @PostMapping("/getAdminByUsername")
    public CommonResult<MemberUserVO> getAdminByUsername(String username) {
        return systemUserService.getAdminByUsername(username);
    }
    @PostMapping("/getUserByUsername")
    public CommonResult<MemberUserVO> getUserByUsername(String username) {
        return systemUserService.getAdminByUsername(username);
    }

    @PostMapping("/login")
    public CommonResult<MemberUserVO> login(@RequestBody LoginVO vo) {
        return systemUserService.login(vo);
    }
}
