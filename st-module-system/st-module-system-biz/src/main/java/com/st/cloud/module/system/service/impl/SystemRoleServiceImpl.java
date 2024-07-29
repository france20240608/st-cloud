package com.st.cloud.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.module.system.mapper.SystemRoleMapper;
import com.st.cloud.module.system.pojo.SystemRoleDO;
import com.st.cloud.module.system.service.SystemRoleService;
import org.springframework.stereotype.Service;

@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRoleDO> implements SystemRoleService {
}
