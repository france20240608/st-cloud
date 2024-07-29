package com.st.cloud.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.pojo.SystemMenuDO;

import java.util.List;

public interface SystemMenuService extends IService<SystemMenuDO> {
    List<SystemMenuRespDTO> getMenuList(SystemMenuRespDTO dto);

    SystemMenuRespDTO getMenuDetail(SystemMenuRespDTO dto);
}
