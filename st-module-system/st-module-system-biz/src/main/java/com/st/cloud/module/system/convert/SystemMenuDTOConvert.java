package com.st.cloud.module.system.convert;

import com.st.cloud.common.pojo.PageResult;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.pojo.SystemMenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemMenuDTOConvert {

    SystemMenuDTOConvert INSTANCE = Mappers.getMapper(SystemMenuDTOConvert.class);

    SystemMenuRespDTO convert(SystemMenuDO bean);

    List<SystemMenuRespDTO> convert(List<SystemMenuDO> list);

    PageResult<SystemMenuRespDTO> convertPage(PageResult<SystemMenuDO> page);
}
