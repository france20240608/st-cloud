package com.st.cloud.framework.redis.config;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.autoconfigure.JetCacheAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMethodCache(basePackages = "com.st.cloud")
@EnableCreateCacheAnnotation
public class JetCacheConfig {
    @Bean
    public JetCacheAutoConfiguration jetCacheAutoConfiguration() {
        return new JetCacheAutoConfiguration();
    }
}
