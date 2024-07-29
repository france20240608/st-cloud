package com.st.cloud.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.agent.mapper.SystemSiteMapper;
import com.st.cloud.agent.pojo.ob.SystemSiteDO;
import com.st.cloud.agent.service.SystemSiteService;
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
