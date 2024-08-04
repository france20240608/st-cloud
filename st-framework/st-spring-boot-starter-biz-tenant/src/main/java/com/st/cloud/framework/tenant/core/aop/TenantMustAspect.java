package com.st.cloud.framework.tenant.core.aop;

import cn.hutool.core.util.ObjectUtil;
import com.st.cloud.common.pojo.BaseReqDTO;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 忽略多租户的 Aspect，基于 {@link TenantIgnore} 注解实现，用于一些全局的逻辑。
 * 例如说，一个定时任务，读取所有数据，进行处理。
 * 又例如说，读取所有数据，进行缓存。
 *
 * @author Tim
 */
@Aspect
@Slf4j
public class TenantMustAspect {

    @Around("@annotation(tenantMust)")
    public Object around(ProceedingJoinPoint joinPoint, TenantMust tenantMust) throws Throwable {
        Object[] args = joinPoint.getArgs();
        boolean isSystemTenant = TenantContextHolder.isSystemTenant();
        for(Object arg : args) {
            if (isSystemTenant
                    && arg instanceof BaseReqDTO dto
                    && ObjectUtil.isNull(dto.getTenantId())) {
                // 系统租户，如果租户ID为null，则设置系统租户ID
                dto.setTenantId(TenantContextHolder.getTenantId());
            } else if(!isSystemTenant
                    && arg instanceof BaseReqDTO dto
                    && ObjectUtil.isNotNull(dto.getTenantId())) {
                // 非系统租户，如果租户ID为不为null，则设置为null
                dto.setTenantId(null);
            }
        }
        // 执行逻辑
        return joinPoint.proceed();
    }

    @Around("execution(* com.st.cloud.common.core.IRedisKey.key(..))")
    public Object interceptAndModifyParameter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof String[] originalArray) {
            String[] modifiedArray = new String[originalArray.length + 1];
            System.arraycopy(originalArray, 0, modifiedArray, 0, originalArray.length);
            modifiedArray[originalArray.length] = TenantContextHolder.getStrTenantId(); // 添加新元素

            // 替换原始参数
            args[0] = modifiedArray;
        }

        // 调用目标方法
        return joinPoint.proceed(args);
    }

}
