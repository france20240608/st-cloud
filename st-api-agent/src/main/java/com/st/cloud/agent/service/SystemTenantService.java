package com.st.cloud.agent.service;

import com.st.cloud.common.pojo.R;

public interface SystemTenantService {
    R<String> getTenantId(String domain);
}
