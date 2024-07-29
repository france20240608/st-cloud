package com.st.cloud.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.agent.pojo.ob.SystemSiteDO;

public interface SystemSiteService extends IService<SystemSiteDO> {
    SystemSiteDO getTenantId(String domain);
}
