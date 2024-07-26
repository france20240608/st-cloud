package com.st.cloud.module.agent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.agent.pojo.ob.SystemRoleDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;

public interface SystemTenantService extends IService<SystemTenantDO> {
    SystemTenantDO getTenantId(String domain);
}
