package com.st.cloud.module.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.st.cloud.module.user.mapper")
@Slf4j
public class StModuleServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StModuleServiceUserApplication.class, args);
        log.info("st-module-service-user 启动成功！");
    }

}
