package com.st.cloud.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.pojo.SystemRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRoleMapper extends BaseMapper<SystemRole> {
    Page<SystemRole> pageRoleList(Page<SystemRole> page, @Param("item") SystemRoleReqDTO dto);

    int countRole(@Param("item") SystemRoleReqDTO dto);
}
