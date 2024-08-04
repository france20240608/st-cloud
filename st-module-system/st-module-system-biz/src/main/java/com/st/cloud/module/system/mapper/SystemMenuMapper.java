package com.st.cloud.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.pojo.SystemMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {
    List<SystemMenu> getMenuList(@Param("item") SystemMenuReqDTO dto);
    Page<SystemMenu> pageMenuList(Page<SystemMenu> page, @Param("item") SystemMenuReqDTO dto);
    SystemMenu getMenuDetail(Long id);

    List<SystemMenu> getAdminPermission(Long userId);

    List<SystemMenu> getRoleMenuList(Long roleId);

    int deleteMenuByID(Long menuId);
}
