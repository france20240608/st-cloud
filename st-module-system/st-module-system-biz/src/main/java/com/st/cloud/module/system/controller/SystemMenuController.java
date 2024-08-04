package com.st.cloud.module.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.service.SystemMenuService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.st.cloud.common.constants.ApiPrefixConstant.API_PREFIX_SYSTEM;


@RestController
@RequestMapping(API_PREFIX_SYSTEM + "/menu")
@Slf4j
public class SystemMenuController {

    @Resource
    private SystemMenuService systemMenuService;

    /****************************************** 菜单管理 ************************************************/
    @PostMapping("/getMenuList")
    @Operation(summary = "获取菜单列表")
    public R<List<SystemMenuRespDTO>> getMenuList(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.getMenuList(dto);
    }

    @PostMapping("/pageMenuList")
    @Operation(summary = "获取菜单分页列表")
    public R<Page<SystemMenuRespDTO>> pageMenuList(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.pageMenuList(dto);
    }

    @PostMapping("/getMenuDetail")
    @Operation(summary = "根据ID获取获取菜单明细")
    public R<SystemMenuRespDTO> getMenuDetail(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.getMenuDetail(dto.getId());
    }

    @PostMapping("/createMenu")
    @Operation(summary = "创建菜单")
    public R<Boolean> createMenu(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.createMenu(dto);
    }

    @PostMapping("/updateMenu")
    @Operation(summary = "更新菜单")
    public R<Boolean> updateMenu(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.updateMenu(dto);
    }

    @PostMapping("/deleteMenu")
    @Operation(summary = "删除菜单")
    public R<Boolean> deleteMenu(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.deleteMenu(dto);
    }

    /****************************************** 角色菜单管理 ************************************************/
    @PostMapping("/getRoleMenuList")
    @Operation(summary = "根据角色ID获取拥有的菜单")
    public R<List<SystemMenuRespDTO>> getRoleMenuList(@RequestBody SystemMenuReqDTO dto) {
        return systemMenuService.getRoleMenuList(dto.getRoleId());
    }

    /****************************************** 系统用户菜单权限 ************************************************/
    @PostMapping("/getAdminPermission")
    public R<List<SystemMenuRespDTO>> getAdminPermission(@RequestBody Long userId) {
        return systemMenuService.getAdminPermission(userId);
    }

}
