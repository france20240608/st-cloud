package com.st.cloud.agent.pojo.convert;

import com.st.cloud.agent.pojo.vo.SystemMenuVO;
import com.st.cloud.common.pojo.PageResult;
import com.st.cloud.module.system.dto.SystemMenuRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemMenuVOConvert {

    SystemMenuVOConvert INSTANCE = Mappers.getMapper(SystemMenuVOConvert.class);

    SystemMenuVO convert(SystemMenuRespDTO bean);

    List<SystemMenuVO> convert(List<SystemMenuRespDTO> list);

    PageResult<SystemMenuVO> convertPage(PageResult<SystemMenuRespDTO> page);
}
