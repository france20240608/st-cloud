package com.st.cloud.module.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.agent.pojo.ob.SystemSiteDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;

public interface SystemSiteService extends IService<SystemSiteDO> {
    SystemSiteDO getTenantId(String domain);
}
