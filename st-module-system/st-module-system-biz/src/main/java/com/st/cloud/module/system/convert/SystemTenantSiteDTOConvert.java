package com.st.cloud.module.system.convert;

import com.st.cloud.common.pojo.PageResult;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.pojo.SystemTenantSiteDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemTenantSiteDTOConvert {

    SystemTenantSiteDTOConvert INSTANCE = Mappers.getMapper(SystemTenantSiteDTOConvert.class);

    SystemTenantSiteRespDTO convert(SystemTenantSiteDO bean);

    List<SystemTenantSiteRespDTO> convert(List<SystemTenantSiteDO> list);

    PageResult<SystemTenantSiteRespDTO> convertPage(PageResult<SystemTenantSiteDO> page);
}
