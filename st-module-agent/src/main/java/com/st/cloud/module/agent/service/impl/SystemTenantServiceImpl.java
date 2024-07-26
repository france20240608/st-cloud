package com.st.cloud.module.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.agent.mapper.MemberUserMapper;
import com.st.cloud.module.agent.mapper.SystemTenantMapper;
import com.st.cloud.module.agent.pojo.ob.MemberUserDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import com.st.cloud.module.agent.service.MemberUserService;
import com.st.cloud.module.agent.service.SystemTenantService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemTenantServiceImpl extends ServiceImpl<SystemTenantMapper, SystemTenantDO> implements SystemTenantService {

    @Resource
    private SystemTenantMapper systemTenantMapper;

    @Override
    public SystemTenantDO getTenantId(String domain) {
        return systemTenantMapper.getTenantId(domain);
    }
}
