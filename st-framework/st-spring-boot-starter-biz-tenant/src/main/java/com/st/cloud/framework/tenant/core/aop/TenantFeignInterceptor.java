package com.st.cloud.framework.tenant.core.aop;

import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import static com.st.cloud.common.base.Constant.HEADER_TENANT_ID;

@Component
public class TenantFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(!TenantContextHolder.isIgnore()){
            // 在这里添加默认的请求头
            requestTemplate.header(HEADER_TENANT_ID, String.valueOf(TenantContextHolder.getTenantId()));
        }
    }
}
