package com.st.cloud.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.pojo.SystemTenantSiteDO;

public interface SystemTenantSiteService extends IService<SystemTenantSiteDO> {
    SystemTenantSiteRespDTO getTenantId(SystemTenantSiteReqDTO domain);
}
