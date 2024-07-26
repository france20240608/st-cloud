package com.st.cloud.module.agent.controller;

import com.st.cloud.common.core.CommonResult;
import com.st.cloud.module.agent.pojo.ob.SystemSiteDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import com.st.cloud.module.agent.service.SystemSiteService;
import com.st.cloud.module.agent.service.SystemTenantService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.st.cloud.module.agent.core.Constant.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX + "/site")
public class SystemSiteController {

    @Resource
    private SystemSiteService systemSiteService;
    @GetMapping("/getTenantId")
    public CommonResult<String> getTenantId(String domain) {
        CommonResult<String> result = new CommonResult<>();
        SystemSiteDO tenantDO = systemSiteService.getTenantId(domain);
        result.setData(String.valueOf(tenantDO.getTenantId()));
        return result;
    }
}
