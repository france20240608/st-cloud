package com.st.cloud.framework.tenant.config;

import com.st.cloud.common.enums.WebFilterOrderEnum;
import com.st.cloud.framework.tenant.core.aop.FeignClientTenantAspect;
import com.st.cloud.framework.tenant.core.aop.TenantIgnoreAspect;
import com.st.cloud.framework.tenant.core.aop.TenantMustAspect;
import com.st.cloud.framework.tenant.core.web.TenantContextWebFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(prefix = "st.tenant", value = "enable", matchIfMissing = true) // 允许使用 glb.tenant.enable=false 禁用多租户
@EnableConfigurationProperties(TenantProperties.class)
public class TenantAutoConfiguration {

    // ========== DB ==========

//    @Bean 这里会产生跟Mybatis的循环依赖，不放到这里
//    public TenantLineInnerInterceptor tenantLineInnerInterceptor(TenantProperties properties, MybatisPlusInterceptor interceptor) {
//        TenantLineInnerInterceptor inner = new TenantLineInnerInterceptor(new TenantDatabaseInterceptor(properties));
//        // 添加到 interceptor 中
//        // 需要加在首个，主要是为了在分页插件前面。这个是 MyBatis Plus 的规定
//        MyBatisUtils.addInterceptor(interceptor, inner, 0);
//        return inner;
//    }

    // ========== WEB ==========
    @Bean
    public FilterRegistrationBean<TenantContextWebFilter> tenantContextWebFilter(TenantProperties properties) {
        FilterRegistrationBean<TenantContextWebFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TenantContextWebFilter(properties));
        registrationBean.setOrder(WebFilterOrderEnum.TENANT_CONTEXT_FILTER);
        return registrationBean;
    }

    // ========== Feign 客户端 ==========
    @Bean
    public FeignClientTenantAspect feignClientTenantAspect() {
        return new FeignClientTenantAspect();
    }


    // ========== AOP ==========
    @Bean
    public TenantIgnoreAspect tenantIgnoreAspect() {
        return new TenantIgnoreAspect();
    }
    @Bean
    public TenantMustAspect tenantMustAspect() {
        return new TenantMustAspect();
    }
}
