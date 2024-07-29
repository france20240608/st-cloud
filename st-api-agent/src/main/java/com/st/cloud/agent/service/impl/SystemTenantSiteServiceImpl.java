package com.st.cloud.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.agent.mapper.SystemTenantSiteMapper;
import com.st.cloud.agent.pojo.ob.SystemTenantSiteDO;
import com.st.cloud.agent.service.SystemTenantSiteService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemTenantSiteServiceImpl extends ServiceImpl<SystemTenantSiteMapper, SystemTenantSiteDO> implements SystemTenantSiteService {

    @Resource
    private SystemTenantSiteMapper SystemTenantSiteMapper;

    @Override
    public SystemTenantSiteDO getTenantId(String domain) {
        return SystemTenantSiteMapper.getTenantId(domain);
    }
}
