package com.st.cloud.framework.tenant.core.web;

import cn.hutool.core.collection.CollUtil;
import com.st.cloud.common.constants.SecurityConstant;
import com.st.cloud.framework.tenant.config.TenantProperties;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


/**
 * 多租户 Context Web 过滤器
 * 将请求 Header 中的 tenant-id 解析出来，添加到 {@link TenantContextHolder} 中，这样后续的 DB 等操作，可以获得到租户编号。
 *
 * @author Tim
 */
@RequiredArgsConstructor
public class TenantContextWebFilter extends OncePerRequestFilter {

    private final TenantProperties tenantProperties;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain chain)
            throws ServletException, IOException {
        String tenantId = request.getHeader(SecurityConstant.HEADER_TENANT_ID);
        if(!isIgnoreUrl(request)) {
            // 不能忽略的URL，设置 tenantId
            if (StringUtils.isNotBlank(tenantId)) {
                // 但是如果租户编号是 0-系统租户（超级管理员租户） 的请求，也设为不需要设置租户信息，但是需要系统租户的血缘，以便传给下游服务
                // TODO 需要思考，有些地方，普通租户的内容是否也允许系统租户能编辑，例如租户的角色，以及角色的权限等等
                if(TenantContextHolder.isSystemTenant(Long.valueOf(tenantId))) {
                    TenantContextHolder.setIgnore(true);
                } else {
                    TenantContextHolder.setIgnore(false);
                }
                TenantContextHolder.setTenantId(Long.valueOf(tenantId));
            }
        } else {
            TenantContextHolder.setIgnore(true);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            // 清理
            TenantContextHolder.clear();
        }
    }

    private boolean isIgnoreUrl(HttpServletRequest request) {
        // 快速匹配，保证性能
//        if (CollUtil.contains(tenantProperties.getIgnoreUrls(), request.getRequestURI())) {
//            return true;
//        }
//        // 逐个 Ant 路径匹配
//        for (String url : tenantProperties.getIgnoreUrls()) {
//            if (pathMatcher.match(url, request.getRequestURI())) {
//                return true;
//            }
//        }
//        return false;

        return CollUtil.contains(tenantProperties.getIgnoreUrls(), request.getRequestURI());
    }

}
