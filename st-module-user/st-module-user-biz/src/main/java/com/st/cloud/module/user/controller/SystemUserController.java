package com.st.cloud.module.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.user.dto.AdminLoginReqDTO;
import com.st.cloud.module.user.dto.AdminLoginRespDTO;
import com.st.cloud.module.user.dto.MemberUserReqDTO;
import com.st.cloud.module.user.dto.MemberUserRespDTO;
import com.st.cloud.module.user.pojo.MemberUser;
import com.st.cloud.module.user.service.MemberUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_USER;


@RestController
@RequestMapping(API_PREFIX_USER + "/admin")
@Slf4j
public class SystemUserController {

    @Resource
    private MemberUserService memberUserService;

    @SentinelResource(value = "admin-getAdminByUserId", blockHandler = "blockHandlerForUser")
    @PostMapping("/getAdminByUserId")
    public R<MemberUser> getAdminByUserId(@RequestBody MemberUserReqDTO dto) {
        MemberUser user = memberUserService.getAdminByUserId(dto.getId());
        R<MemberUser> result = new R<>();
        result.setData(user);
        return result;
    }

    @SentinelResource(value = "admin-getAdminByUsername", blockHandler = "blockHandlerForUser")
    @PostMapping("/getAdminByUsername")
    public R<MemberUserRespDTO> getAdminByUsername(@RequestBody MemberUserReqDTO dto) {
        return memberUserService.getAdminByUsername(dto.getUsername());
    }

    @SentinelResource(value = "admin-getAdminLoginUser", blockHandler = "blockHandlerForUser")
    @PostMapping("/getAdminLoginUser")
    public R<AdminLoginRespDTO> getAdminLoginUser(@RequestBody AdminLoginReqDTO dto) {
        return memberUserService.getAdminLoginUser(dto);
    }

    public String blockHandlerForUser(BlockException ex) {
        log.info("===============> {}", "user-list is blocked", ex);
        return "user-list sentinel is blocked";
    }
}
