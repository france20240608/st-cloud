package com.st.cloud.module.agent.controller;

import com.st.cloud.common.core.CommonResult;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import com.st.cloud.module.agent.service.SystemTenantService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/tenant")
public class TenantController {

    @Resource
    private SystemTenantService systemTenantService;
    @GetMapping("/getTenantId")
    public CommonResult<String> getTenantId(String domain) {
        CommonResult<String> result = new CommonResult<>();
        SystemTenantDO tenantDO = systemTenantService.getTenantId(domain);
        result.setData(String.valueOf(tenantDO.getTenantId()));
        return result;
    }
}
