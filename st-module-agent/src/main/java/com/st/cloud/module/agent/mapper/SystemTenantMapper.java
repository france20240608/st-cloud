package com.st.cloud.module.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.module.agent.pojo.ob.SystemRoleDO;
import com.st.cloud.module.agent.pojo.ob.SystemTenantDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemTenantMapper extends BaseMapper<SystemTenantDO> {
    SystemTenantDO getTenantId(@Param("domain") String domain);
}
