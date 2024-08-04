package com.st.cloud.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.system.mapper.SystemTenantMapper;
import com.st.cloud.module.system.pojo.SystemTenant;
import com.st.cloud.module.system.service.SystemTenantService;
import org.springframework.stereotype.Service;

@Service
public class SystemTenantServiceImpl extends ServiceImpl<SystemTenantMapper, SystemTenant> implements SystemTenantService {
}
