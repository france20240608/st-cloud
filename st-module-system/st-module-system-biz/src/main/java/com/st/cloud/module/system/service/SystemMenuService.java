package com.st.cloud.module.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.user.pojo.SystemMenuDO;

import java.util.List;

public interface SystemMenuService extends IService<SystemMenuDO> {
    List<SystemMenuRespDTO> getMenuList(SystemMenuRespDTO dto);
}
