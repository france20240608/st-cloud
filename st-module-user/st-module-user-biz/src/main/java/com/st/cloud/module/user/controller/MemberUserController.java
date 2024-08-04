package com.st.cloud.module.user.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.st.cloud.common.pojo.R;
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
@RequestMapping(API_PREFIX_USER + "/member")
@Slf4j
public class MemberUserController {

    @Resource
    private MemberUserService memberUserService;

    @SentinelResource(value = "member-getUserByUserId", blockHandler = "blockHandlerForUser")
    @PostMapping("/getUserByUserId")
    public R<MemberUser> getUserByUserId(@RequestBody MemberUserReqDTO dto) {
        MemberUser user = memberUserService.getUserByUserId(dto.getId());
        R<MemberUser> result = new R<>();
        result.setData(user);
        return result;
    }

    @SentinelResource(value = "member-getUserByUsername", blockHandler = "blockHandlerForUser")
    @PostMapping("/getUserByUsername")
    public R<MemberUserRespDTO> getUserByUsername(@RequestBody MemberUserReqDTO reqDTO) {
        return memberUserService.getUserByUsername(reqDTO.getUsername());
    }

    public String blockHandlerForUser(BlockException ex) {
        log.info("===============> {}", "user-list is blocked", ex);
        return "user-list sentinel is blocked";
    }
}
