package com.st.cloud;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableMethodCache(basePackages = "com.st")
public class StModuleAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StModuleAgentApplication.class, args);
    }

}
