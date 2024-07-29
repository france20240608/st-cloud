package com.st.cloud.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.agent.pojo.ob.SystemTenantSiteDO;

public interface SystemTenantSiteService extends IService<SystemTenantSiteDO> {
    SystemTenantSiteDO getTenantId(String domain);
}
