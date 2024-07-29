package com.st.cloud.agent.service;

import com.st.cloud.common.pojo.CommonResult;

public interface SystemTenantService {
    CommonResult<String> getTenantId(String domain);
}
