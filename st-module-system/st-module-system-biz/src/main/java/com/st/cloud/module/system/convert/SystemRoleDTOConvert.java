package com.st.cloud.module.system.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.module.system.dto.SystemRoleReqDTO;
import com.st.cloud.module.system.dto.SystemRoleRespDTO;
import com.st.cloud.module.system.pojo.SystemRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemRoleDTOConvert {

    SystemRoleDTOConvert INSTANCE = Mappers.getMapper(SystemRoleDTOConvert.class);

    /********************** D0 -> DTO ***********************/
    SystemRoleRespDTO convert(SystemRole bean);

    List<SystemRoleRespDTO> convert(List<SystemRole> list);

    Page<SystemRoleRespDTO> convert(Page<SystemRole> page);

    /********************** DT0 -> DO ***********************/
    SystemRole convert(SystemRoleReqDTO bean);
}
