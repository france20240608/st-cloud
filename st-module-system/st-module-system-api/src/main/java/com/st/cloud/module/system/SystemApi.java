package com.st.cloud.module.system;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.dto.SystemRoleRespDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_SYSTEM;

@FeignClient(name = "st-module-system-biz")
public interface SystemApi {
    /******************************** 血缘相关 *********************************/
    @PostMapping(API_PREFIX_SYSTEM + "/tenantsite/getTenantId")
    R<SystemTenantSiteRespDTO> getTenantId(@RequestBody SystemTenantSiteReqDTO dto);

    /******************************** 菜单相关 *********************************/
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getMenuList")
    R<List<SystemMenuRespDTO>> getMenuList(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/pageMenuList")
    R<Page<SystemMenuRespDTO>> pageMenuList(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getMenuDetail")
    R<SystemMenuRespDTO> getMenuDetail(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/createMenu")
    R<Boolean> createMenu(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/updateMenu")
    R<Boolean> updateMenu(@RequestBody SystemMenuReqDTO dto);
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getRoleMenuList")
    R<List<SystemMenuRespDTO>> getRoleMenuList(@RequestBody SystemMenuReqDTO dto);

    /******************************** 权限相关 *********************************/
    @PostMapping(API_PREFIX_SYSTEM + "/menu/getAdminPermission")
    R<List<SystemMenuRespDTO>> getAdminPermission(@RequestBody Long userId);

    /******************************** 角色相关 *********************************/
    @PostMapping(API_PREFIX_SYSTEM + "/role/pageRoleList")
    R<Page<SystemRoleRespDTO>> pageRoleList(@RequestBody SystemRoleReqDTO dto);


}
