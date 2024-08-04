package com.st.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class StModuleAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StModuleAgentApplication.class, args);
        log.info("st-api-agent 启动成功！");
    }

}
