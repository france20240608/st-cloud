package com.st.cloud.framework.tenant.core.web;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.st.cloud.framework.tenant.config.TenantProperties;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNullApi;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.st.cloud.common.base.Constant.HEADER_TENANT_ID;

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
        if(!isIgnoreUrl(request)) {
            // 设置 tenantId
            System.out.println(request.getRequestURI());
            String tenantId = request.getHeader(HEADER_TENANT_ID);
            if (StringUtils.isNotBlank(tenantId)) {
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
