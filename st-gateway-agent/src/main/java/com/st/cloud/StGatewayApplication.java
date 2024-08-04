package com.st.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(StGatewayApplication.class, args);
        log.info("st-gateway-agent 启动成功！");
    }
}
