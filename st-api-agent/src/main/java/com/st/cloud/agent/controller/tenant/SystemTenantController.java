package com.st.cloud.agent.controller.tenant;

import com.st.cloud.agent.core.Constant;
import com.st.cloud.agent.service.SystemTenantService;
import com.st.cloud.common.pojo.CommonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_PREFIX + "/tenant")
public class SystemTenantController {

    @Resource
    private SystemTenantService SystemTenantSiteService;
    @GetMapping("/getTenantId")
    public CommonResult<String> getTenantId(String domain) {
        return SystemTenantSiteService.getTenantId(domain);
    }
}
