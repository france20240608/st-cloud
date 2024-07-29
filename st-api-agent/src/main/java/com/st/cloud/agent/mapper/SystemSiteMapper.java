package com.st.cloud.agent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.st.cloud.agent.pojo.ob.SystemSiteDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSiteMapper extends BaseMapper<SystemSiteDO> {
    SystemSiteDO getTenantId(@Param("domain") String domain);
}
