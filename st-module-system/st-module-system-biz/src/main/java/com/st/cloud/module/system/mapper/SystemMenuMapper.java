package com.st.cloud.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.user.pojo.SystemMenuDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemMenuMapper extends BaseMapper<SystemMenuDO> {
    List<SystemMenuDO> getMenuList(SystemMenuRespDTO dto);
}
