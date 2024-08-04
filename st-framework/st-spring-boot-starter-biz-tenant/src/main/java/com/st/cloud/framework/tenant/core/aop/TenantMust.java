package com.st.cloud.framework.tenant.core.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 某系业务上，系统租户管理员操作，必须要传租户编号
 * 例如： 系统租户账号登录，注册，创建角色等
 *
 *
 * @author Tim
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TenantMust {
}
