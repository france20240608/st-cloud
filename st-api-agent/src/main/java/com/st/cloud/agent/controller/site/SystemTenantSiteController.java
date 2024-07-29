package com.st.cloud.agent.controller.site;

import com.st.cloud.agent.core.Constant;
import com.st.cloud.agent.pojo.ob.SystemTenantSiteDO;
import com.st.cloud.agent.service.SystemTenantSiteService;
import com.st.cloud.common.pojo.CommonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.API_PREFIX + "/site")
public class SystemTenantSiteController {

    @Resource
    private SystemTenantSiteService SystemTenantSiteService;
    @GetMapping("/getTenantId")
    public CommonResult<String> getTenantId(String domain) {
        CommonResult<String> result = new CommonResult<>();
        SystemTenantSiteDO tenantDO = SystemTenantSiteService.getTenantId(domain);
        result.setData(String.valueOf(tenantDO.getTenantId()));
        return result;
    }
}
