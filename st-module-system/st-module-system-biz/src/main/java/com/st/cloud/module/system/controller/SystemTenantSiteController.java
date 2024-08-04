package com.st.cloud.module.system.controller;


import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.service.SystemTenantSiteService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_SYSTEM;


@RestController
@RequestMapping(API_PREFIX_SYSTEM + "/tenantsite")
@Slf4j
public class SystemTenantSiteController {

    @Resource
    private SystemTenantSiteService systemTenantSiteService;

    @PostMapping("/getTenantId")
    public R<SystemTenantSiteRespDTO> getTenantId(@RequestBody SystemTenantSiteReqDTO dto) {
        return R.success(systemTenantSiteService.getTenantId(dto));
    }

}
