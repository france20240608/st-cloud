package com.st.cloud.framework.security.config;

import com.st.cloud.framework.security.core.aop.PreAuthorizeAspect;
import com.st.cloud.framework.security.core.util.AuthUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class SecurityAutoConfiguration {
    @Bean
    public PreAuthorizeAspect preAuthorizeAspect(AuthUtil authUtil) {
        return new PreAuthorizeAspect(authUtil);
    }
}
