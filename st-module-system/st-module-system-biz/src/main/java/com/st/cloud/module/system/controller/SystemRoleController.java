package com.st.cloud.module.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.dto.SystemRoleRespDTO;
import com.st.cloud.module.system.service.SystemRoleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_SYSTEM;


@RestController
@RequestMapping(API_PREFIX_SYSTEM + "/role")
@Slf4j
public class SystemRoleController {

    @Resource
    private SystemRoleService systemRoleService;

    @PostMapping("/pageRoleList")
    @Operation(summary = "获取角色列表")
    public R<Page<SystemRoleRespDTO>> pageRoleList(@RequestBody SystemRoleReqDTO dto) {
        return systemRoleService.pageRoleList(dto);
    }

    @PostMapping("/createRole")
    @Operation(summary = "创建角色")
    public R<Boolean> createRole(@RequestBody SystemRoleReqDTO dto) {
        return systemRoleService.createRole(dto);
    }

}
