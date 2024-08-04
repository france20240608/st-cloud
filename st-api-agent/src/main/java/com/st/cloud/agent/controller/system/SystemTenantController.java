package com.st.cloud.agent.controller.system;

import com.st.cloud.agent.common.AgentConstant;
import com.st.cloud.agent.service.SystemTenantService;
import com.st.cloud.common.pojo.R;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AgentConstant.API_PREFIX + "/tenant")
public class SystemTenantController {

    @Resource
    private SystemTenantService SystemTenantSiteService;
    @GetMapping("/getTenantId")
    @Operation(summary = "获取血缘，主要用于gateway获取tenantId，放到请求头tenant-id")
    public R<String> getTenantId(String domain) {
        return SystemTenantSiteService.getTenantId(domain);
    }
}
