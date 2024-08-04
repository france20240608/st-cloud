package com.st.cloud.framework.tenant.core.aop;

import com.st.cloud.common.constants.SecurityConstant;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;


@Component
public class TenantFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
//        if(!TenantContextHolder.isIgnore()){
            // 添加血缘给下游的请求头
            requestTemplate.header(SecurityConstant.HEADER_TENANT_ID, String.valueOf(TenantContextHolder.getTenantId()));
//        }
    }
}
