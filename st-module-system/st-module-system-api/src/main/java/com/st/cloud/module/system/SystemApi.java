package com.st.cloud.module.system;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "st-module-system-biz")
public interface SystemApi {

}
