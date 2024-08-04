package com.st.cloud.module.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.pojo.SystemMenu;

import java.util.List;

public interface SystemMenuService extends IService<SystemMenu> {
    R<List<SystemMenuRespDTO>> getMenuList(SystemMenuReqDTO dto);
    R<Page<SystemMenuRespDTO>> pageMenuList(SystemMenuReqDTO dto);
    R<SystemMenuRespDTO> getMenuDetail(Long roleId);
    R<List<SystemMenuRespDTO>> getAdminPermission(Long userId);

    R<List<SystemMenuRespDTO>> getRoleMenuList(Long roleId);

    R<Boolean> createMenu(SystemMenuReqDTO dto);

    R<Boolean> updateMenu(SystemMenuReqDTO dto);

    R<Boolean> deleteMenu(SystemMenuReqDTO dto);
}
