package com.st.cloud.agent.controller.user;

import com.st.cloud.agent.common.AgentConstant;
import com.st.cloud.agent.pojo.vo.LoginVO;
import com.st.cloud.agent.pojo.vo.MemberUserVO;
import com.st.cloud.agent.service.SystemUserService;
import com.st.cloud.common.pojo.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AgentConstant.API_PREFIX + "/user")
public class SystemUserController {

    @Resource
    private SystemUserService systemUserService;

    @PostMapping("/getMemberByUsername")
    public R<MemberUserVO> getMemberByUsername(String username) {
        return systemUserService.getMemberByUsername(username);
    }

    @PostMapping("/getAdminByUsername")
    public R<MemberUserVO> getAdminByUsername(String username) {
        return systemUserService.getAdminByUsername(username);
    }
    @PostMapping("/getUserByUsername")
    public R<MemberUserVO> getUserByUsername(String username) {
        return systemUserService.getAdminByUsername(username);
    }

    @PostMapping("/login")
    public R<LoginVO> login(@RequestBody LoginVO vo) {
        return systemUserService.login(vo);
    }
}
