package com.st.cloud.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.system.pojo.SystemTenantSiteDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemTenantSiteMapper extends BaseMapper<SystemTenantSiteDO> {
    SystemTenantSiteDO getTenantId(@Param("domain") String domain);
}
