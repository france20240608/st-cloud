package com.st.cloud.agent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.agent.mapper.SystemTenantMapper;
import com.st.cloud.agent.pojo.ob.SystemTenantDO;
import com.st.cloud.agent.service.SystemTenantService;
import org.springframework.stereotype.Service;

@Service
public class SystemTenantServiceImpl extends ServiceImpl<SystemTenantMapper, SystemTenantDO> implements SystemTenantService {
}
