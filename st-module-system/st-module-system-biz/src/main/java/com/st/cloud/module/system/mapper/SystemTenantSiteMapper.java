package com.st.cloud.module.system.mapper;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.system.dto.SystemTenantSiteReqDTO;
import com.st.cloud.module.system.pojo.SystemTenantSite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemTenantSiteMapper extends BaseMapper<SystemTenantSite> {

    @Cached(name="tenant:site:", key="args[0].domain", expire = 3600)
    SystemTenantSite getTenantId(@Param("item") SystemTenantSiteReqDTO dto);
}
