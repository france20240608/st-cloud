package com.st.cloud.framework.tenant.core.aop;

import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 给feignClient请求头添加TenantId
 *
 * @author 芋道源码
 */
@Aspect
@Slf4j
public class FeignClientTenantAspect {

    @Around("@annotation(feignClient)")
    public Object around(ProceedingJoinPoint joinPoint, FeignClient feignClient) throws Throwable {
        // 在这里添加动态请求头逻辑
        // 例如：ThreadLocal存储，或者从其他上下文中获取值
        TenantFeignInterceptor customFeignInterceptor = new TenantFeignInterceptor();
        // 动态设置头信息，可以使用ThreadLocal等存储临时数据
        customFeignInterceptor.apply(new RequestTemplate());

        return joinPoint.proceed();
    }

}
