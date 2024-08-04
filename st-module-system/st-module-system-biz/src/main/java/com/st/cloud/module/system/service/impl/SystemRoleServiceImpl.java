package com.st.cloud.module.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.common.pojo.R;
import com.st.cloud.framework.tenant.core.aop.TenantMust;
import com.st.cloud.module.system.convert.SystemRoleDTOConvert;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.dto.SystemRoleRespDTO;
import com.st.cloud.module.system.mapper.SystemRoleMapper;
import com.st.cloud.module.system.pojo.SystemRole;
import com.st.cloud.module.system.service.SystemRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements SystemRoleService {

    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Override
    public R<Page<SystemRoleRespDTO>> pageRoleList(SystemRoleReqDTO dto) {
        Page<SystemRole> page = systemRoleMapper.pageRoleList(new Page<>(dto.getPageNum(), dto.getPageSize()), dto);
        return R.success(SystemRoleDTOConvert.INSTANCE.convert(page));
    }

    // 如果是系统租户管理员进行编辑，需要传入具体的租户。普通租户会自动添加租户ID到sql中
    // 如果是系统租户增加角色，需要前端传入租户ID，如果不传，默认创建的是系统租户的角色
    @Override
    @TenantMust
    public R<Boolean> createRole(SystemRoleReqDTO dto) {
        if (systemRoleMapper.countRole(dto) > 0) {
            return R.fail("99999", "角色已存在");
        }
        int count = systemRoleMapper.insert(SystemRoleDTOConvert.INSTANCE.convert(dto));
        return R.success(count == 1);
    }
}
