package com.st.cloud.agent.pojo.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.agent.pojo.vo.SystemTenantSiteVO;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemTenantSiteVOConvert {

    SystemTenantSiteVOConvert INSTANCE = Mappers.getMapper(SystemTenantSiteVOConvert.class);

    /********************** VO -> DTO ***********************/
    SystemTenantSiteVO convert(SystemTenantSiteRespDTO bean);

    List<SystemTenantSiteVO> convert(List<SystemTenantSiteRespDTO> list);

    Page<SystemTenantSiteVO> convert(Page<SystemTenantSiteRespDTO> page);
}
