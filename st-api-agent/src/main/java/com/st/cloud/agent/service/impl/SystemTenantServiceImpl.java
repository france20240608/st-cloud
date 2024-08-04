package com.st.cloud.agent.service.impl;

import com.st.cloud.agent.service.SystemTenantService;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.SystemApi;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SystemTenantServiceImpl implements SystemTenantService {

    @Resource
    private SystemApi systemApi;

    @Override
    public R<String> getTenantId(String domain) {
        SystemTenantSiteReqDTO dto = new SystemTenantSiteReqDTO();
        dto.setDomain(domain);
        R<SystemTenantSiteRespDTO> tenant = systemApi.getTenantId(dto);
        if(Objects.nonNull(tenant.getData())) {
            return R.success(String.valueOf(tenant.getData().getTenantId()));
        }
        return R.fail(tenant.getCode(), tenant.getMessage());
    }
}
