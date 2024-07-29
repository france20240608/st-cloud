package com.st.cloud.agent.service.impl;

import com.st.cloud.agent.service.SystemTenantSiteService;
import com.st.cloud.common.pojo.CommonResult;
import com.st.cloud.module.system.SystemApi;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SystemTenantSiteServiceImpl implements SystemTenantSiteService {

    @Resource
    private SystemApi systemApi;

    @Override
    public CommonResult<String> getTenantId(String domain) {
        SystemTenantSiteReqDTO dto = new SystemTenantSiteReqDTO();
        dto.setDomain(domain);
        CommonResult<SystemTenantSiteRespDTO> tenant = systemApi.getTenantId(dto);
        if(Objects.nonNull(tenant) && Objects.nonNull(tenant.getData())) {
            return CommonResult.success(String.valueOf(tenant.getData().getTenantId()));
        } else {
            return CommonResult.fail("10001","获取租户ID失败");
        }
    }
}
