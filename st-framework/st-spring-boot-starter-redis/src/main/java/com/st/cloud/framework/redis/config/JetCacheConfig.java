package com.st.cloud.framework.redis.config;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

@AutoConfigureBefore(JetCacheAutoConfiguration.class)
@EnableMethodCache(basePackages = "com.st.cloud")
public class JetCacheConfig {

    // TODO 先注释，这个只能给remote加前缀， local的在启动的时候就已经创建好，不能动态修改
    // TODO local的只能在key拼接的时候添加血缘前缀，侵入性太大，需要思考如何改进
//    @Primary
//    @Bean
//    public TenantCacheManager tenantCacheManager(SpringConfigProvider springConfigProvider) {
//        TenantCacheManager tenantCacheManager = new TenantCacheManager();
//        tenantCacheManager.setCacheBuilderTemplate(springConfigProvider.getCacheBuilderTemplate());
//        return tenantCacheManager;
//    }
}
