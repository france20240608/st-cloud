package com.st.cloud.module.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.agent.pojo.ob.SystemSiteDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSiteMapper extends BaseMapper<SystemSiteDO> {
    SystemSiteDO getTenantId(@Param("domain") String domain);
}
