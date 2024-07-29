package com.st.cloud.agent.service;

import com.st.cloud.common.pojo.CommonResult;

public interface SystemTenantSiteService {
    CommonResult<String> getTenantId(String domain);
}
