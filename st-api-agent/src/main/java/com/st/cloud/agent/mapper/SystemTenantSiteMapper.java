package com.st.cloud.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.agent.pojo.ob.SystemTenantSiteDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemTenantSiteMapper extends BaseMapper<SystemTenantSiteDO> {
    SystemTenantSiteDO getTenantId(@Param("domain") String domain);
}
