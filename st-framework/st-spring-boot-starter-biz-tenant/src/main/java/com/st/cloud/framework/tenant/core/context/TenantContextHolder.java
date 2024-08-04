package com.st.cloud.framework.tenant.core.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * 多租户上下文 Holder
 *
 * @author Tim
 */
public class TenantContextHolder {

    public static final Long TENANT_SYSTEM_TENANT_ID = 0L;
    /**
     * 当前租户编号
     */
    private static final ThreadLocal<Long> TENANT_ID = new TransmittableThreadLocal<>();

    /**
     * 是否忽略租户
     */
    private static final ThreadLocal<Boolean> IGNORE = new TransmittableThreadLocal<>();

    /**
     * 获得租户编号
     *
     * @return 租户编号
     */
    public static Long getTenantId() {
        return TENANT_ID.get();
    }

    /**
     * 获得String类型租户编号
     *
     * @return 租户编号
     */
    public static String getStrTenantId() {
        return String.valueOf(TENANT_ID.get());
    }

    /**
     * 获得String类型租户编号
     *
     * @return 租户编号
     */
    public static String tenantPrefix() {
        if(!isIgnore()) {
            return getStrTenantId() + ":";
        }
        return "";
    }

    /**
     * 判断是否是系统租户
     *
     * @return 是否是系统租户
     */
    public static boolean isSystemTenant() {
        return TENANT_SYSTEM_TENANT_ID.equals(getTenantId());
    }

    /**
     * 判断是否是系统租户
     * @param tenantId 租户ID
     * @return 是否是系统租户
     */
    public static boolean isSystemTenant(Long tenantId) {
        return TENANT_SYSTEM_TENANT_ID.equals(tenantId);
    }

    /**
     * 获得租户编号。如果不存在，则抛出 NullPointerException 异常
     *
     * @return 租户编号
     */
    public static Long getRequiredTenantId() {
        Long tenantId = getTenantId();
        if (tenantId == null) {
            throw new NullPointerException("TenantContextHolder 不存在租户编号！");
        }
        return tenantId;
    }

    public static void setTenantId(Long tenantId) {
        TENANT_ID.set(tenantId);
    }

    public static void setIgnore(Boolean ignore) {
        IGNORE.set(ignore);
    }

    /**
     * 当前是否忽略租户
     *
     * @return 是否忽略
     */
    public static boolean isIgnore() {
        return IGNORE.get();
    }

    public static void clear() {
        TENANT_ID.remove();
        IGNORE.remove();
    }

}
