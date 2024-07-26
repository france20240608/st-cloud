package com.st.cloud.module.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.agent.mapper.SystemSiteMapper;
import com.st.cloud.module.agent.mapper.SystemTenantMapper;
import com.st.cloud.module.agent.pojo.ob.SystemSiteDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import com.st.cloud.module.agent.service.SystemSiteService;
import com.st.cloud.module.agent.service.SystemTenantService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemSiteServiceImpl extends ServiceImpl<SystemSiteMapper, SystemSiteDO> implements SystemSiteService {

    @Resource
    private SystemSiteMapper systemSiteMapper;

    @Override
    public SystemSiteDO getTenantId(String domain) {
        return systemSiteMapper.getTenantId(domain);
    }
}
