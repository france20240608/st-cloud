package com.st.cloud.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.system.convert.SystemTenantSiteDTOConvert;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.mapper.SystemTenantSiteMapper;
import com.st.cloud.module.system.pojo.SystemTenantSite;
import com.st.cloud.module.system.service.SystemTenantSiteService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemTenantSiteServiceImpl extends ServiceImpl<SystemTenantSiteMapper, SystemTenantSite> implements SystemTenantSiteService {

    @Resource
    private SystemTenantSiteMapper systemTenantSiteMapper;

    @Override
    public SystemTenantSiteRespDTO getTenantId(SystemTenantSiteReqDTO dto) {
        SystemTenantSite tenant = systemTenantSiteMapper.getTenantId(dto);
        return SystemTenantSiteDTOConvert.INSTANCE.convert(tenant);
    }
}
