package com.st.cloud.module.system.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.module.system.dto.SystemMenuReqDTO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import com.st.cloud.module.system.pojo.SystemMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemMenuDTOConvert {

    SystemMenuDTOConvert INSTANCE = Mappers.getMapper(SystemMenuDTOConvert.class);

    /********************** D0 -> DTO ***********************/
    SystemMenuRespDTO convert(SystemMenu bean);

    List<SystemMenuRespDTO> convert(List<SystemMenu> list);

    Page<SystemMenuRespDTO> convert(Page<SystemMenu> page);

    /********************** DTO -> D0 ***********************/
    SystemMenu convert(SystemMenuReqDTO bean);
}
