package com.st.cloud.agent.pojo.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemMenuVOConvert {

    SystemMenuVOConvert INSTANCE = Mappers.getMapper(SystemMenuVOConvert.class);

    /********************** VO -> DTO ***********************/
    SystemMenuVO convert(SystemMenuRespDTO bean);

    List<SystemMenuVO> convert(List<SystemMenuRespDTO> list);

    Page<SystemMenuVO> convert(Page<SystemMenuRespDTO> page);
}
