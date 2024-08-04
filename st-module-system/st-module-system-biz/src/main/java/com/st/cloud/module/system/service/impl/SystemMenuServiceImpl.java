package com.st.cloud.module.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.st.cloud.common.pojo.R;
import com.st.cloud.module.system.convert.SystemMenuDTOConvert;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.mapper.SystemMenuMapper;
import com.st.cloud.module.system.pojo.SystemMenu;
import com.st.cloud.module.system.service.SystemMenuService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu> implements SystemMenuService {
    @Resource
    SystemMenuMapper systemMenuMapper;

    @Override
    public R<List<SystemMenuRespDTO>> getMenuList(SystemMenuReqDTO dto) {
        List<SystemMenu> list = systemMenuMapper.getMenuList(dto);
        return R.success(SystemMenuDTOConvert.INSTANCE.convert(list));
    }

    @Override
    public R<Page<SystemMenuRespDTO>> pageMenuList(SystemMenuReqDTO dto) {
        Page<SystemMenu> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        page = systemMenuMapper.pageMenuList(page, dto);
        return R.success(SystemMenuDTOConvert.INSTANCE.convert(page));
    }

    @Override
    public R<SystemMenuRespDTO> getMenuDetail(Long id) {
        SystemMenu detail = systemMenuMapper.getMenuDetail(id);
        return R.success(SystemMenuDTOConvert.INSTANCE.convert(detail));
    }

    @Override
    public R<List<SystemMenuRespDTO>> getAdminPermission(Long userId) {
        List<SystemMenu> menus = systemMenuMapper.getAdminPermission(userId);
        return R.success(SystemMenuDTOConvert.INSTANCE.convert(menus));
    }

    @Override
    public R<List<SystemMenuRespDTO>> getRoleMenuList(Long roleId) {
        List<SystemMenu> menus = systemMenuMapper.getRoleMenuList(roleId);
        return R.success(SystemMenuDTOConvert.INSTANCE.convert(menus));
    }

    @Override
    public R<Boolean> createMenu(SystemMenuReqDTO dto) {
        SystemMenu systemMenu = SystemMenuDTOConvert.INSTANCE.convert(dto);

        // 检查父菜单是否存在
        Long parentId = dto.getParentId();
        SystemMenu menuDetail = systemMenuMapper.getMenuDetail(parentId);
        if(Objects.isNull(menuDetail)) {
            return R.fail("99999", "父菜单不存在");
        }

        // 检查父菜单下是否有同名菜单
        SystemMenuReqDTO searchDto = new SystemMenuReqDTO();
        searchDto.setParentId(dto.getParentId());
        searchDto.setName(dto.getName());
        List<SystemMenu> menuList = systemMenuMapper.getMenuList(searchDto);
        if (CollectionUtil.isNotEmpty(menuList)) {
            return R.fail("99999", "名字重复");
        }

        int count = systemMenuMapper.insert(systemMenu);
        return R.success(count == 1);
    }

    @Override
    public R<Boolean> updateMenu(SystemMenuReqDTO dto) {
        SystemMenu systemMenu = SystemMenuDTOConvert.INSTANCE.convert(dto);

        // 检查父菜单是否存在
        Long parentId = dto.getParentId();
        SystemMenu menuDetail = systemMenuMapper.getMenuDetail(parentId);
        if(Objects.isNull(menuDetail)) {
            return R.fail("99999", "父菜单不存在");
        }

        // 检查父菜单下是否有同名菜单
        SystemMenuReqDTO searchDto = new SystemMenuReqDTO();
        searchDto.setParentId(dto.getParentId());
        searchDto.setName(dto.getName());
        List<SystemMenu> menuList = systemMenuMapper.getMenuList(searchDto);
        if (CollectionUtil.isNotEmpty(menuList) && !menuList.getFirst().getId().equals(dto.getId())) {
            return R.fail("99999", "名字重复");
        }

        int count = systemMenuMapper.updateById(systemMenu);
        return R.success(count == 1);
    }

    @Override
    public R<Boolean> deleteMenu(SystemMenuReqDTO dto) {
        int count = systemMenuMapper.deleteMenuByID(dto.getId());
        log.info("删除菜单条数：{}", count);
        return R.success(count > 1);
    }
}
