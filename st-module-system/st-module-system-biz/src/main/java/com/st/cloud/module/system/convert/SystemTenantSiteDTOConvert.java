package com.st.cloud.module.system.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.st.cloud.module.system.dto.SystemTenantSiteRespDTO;
import com.st.cloud.module.system.pojo.SystemTenantSite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SystemTenantSiteDTOConvert {

    SystemTenantSiteDTOConvert INSTANCE = Mappers.getMapper(SystemTenantSiteDTOConvert.class);

    /********************** D0 -> DTO ***********************/
    SystemTenantSiteRespDTO convert(SystemTenantSite bean);

    List<SystemTenantSiteRespDTO> convert(List<SystemTenantSite> list);

    Page<SystemTenantSiteRespDTO> Page(Page<SystemTenantSite> page);

    /********************** DT0 -> DO ***********************/
}
