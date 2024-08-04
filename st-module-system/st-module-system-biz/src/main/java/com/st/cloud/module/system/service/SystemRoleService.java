package com.st.cloud.module.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.dto.SystemRoleRespDTO;
import com.st.cloud.module.system.pojo.SystemRole;

public interface SystemRoleService extends IService<SystemRole> {
    R<Page<SystemRoleRespDTO>> pageRoleList(SystemRoleReqDTO dto);

    R<Boolean> createRole(SystemRoleReqDTO dto);
}
