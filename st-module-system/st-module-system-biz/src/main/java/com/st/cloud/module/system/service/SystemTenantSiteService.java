package com.st.cloud.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.pojo.SystemTenantSite;

public interface SystemTenantSiteService extends IService<SystemTenantSite> {
    SystemTenantSiteRespDTO getTenantId(SystemTenantSiteReqDTO domain);
}
