package com.st.cloud.agent.enums;

import com.st.cloud.common.core.IRedisKey;
import com.st.cloud.framework.tenant.core.context.TenantContextHolder;

import java.time.Duration;

import static com.st.cloud.common.constants.CommonConstant.COLON;

/**
 * Redis key 管理枚举, 各后端服务模块各自定义自己的一份，modulePrefix改成各自模块的前缀
 *
 * @author ：Tim
 */
public enum CacheKey implements IRedisKey {

    // 例子, 没有在用
    ADMIN_LOGIN_PREFIX("login", 60 * 60 * 24 * 7),

    ;

    /**
     * 每个模块的前缀
     */
    private final String modulePrefix = "agent:";
    /**
     * key 原始key
     */
    private final String key;
    /**
     * 过期时间
     */
    private final Integer duration;

    CacheKey(String key, Integer duration) {
        this.key = key;
        this.duration = duration;
    }

    /**
     * 不带血缘的redis key
     * @param keys
     * @return 不带血缘的redis key
     */
    @Override
    public String key(String... keys) {
        StringBuilder sb = new StringBuilder(key);
        for (String s : keys) {
            sb.append(COLON).append(s);
        }
        return modulePrefix + COLON + sb;
    }

    /**
     * 带血缘的redis key
     * @param keys
     * @return 带血缘的redis key
     */
    @Override
    public String keyWithTenant(String... keys) {
        String cacheKey = key;

        // 如果需要血缘，拼上租户ID
        TenantContextHolder.getStrTenantId();
        cacheKey += COLON + TenantContextHolder.getStrTenantId();

        StringBuilder sb = new StringBuilder(cacheKey);
        for (String s : keys) {
            sb.append(COLON).append(s);
        }
        return modulePrefix + COLON + sb;
    }

    /**
     * 缓存过期时间
     * @return 缓存过期时间
     */
    @Override
    public Duration duration() {
        return Duration.ofSeconds(duration);
    }
}
