package com.st.cloud.common.constants;

/**
 * 权限相关通用常量
 * 
 * @author gpx
 */
public interface SecurityConstant
{


    /**
     * 用户ID字段
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 用户名字段
     */
    String DETAILS_USERNAME = "username";

    /**
     * 用户名字段
     */
    String DETAILS_USER_IP = "user_ip";

    /**
     * 授权信息字段
     */
    String HEADER_TOKEN = "token";

    /**
     * 租户ID
     */
    String HEADER_TENANT_ID = "tenant-id";

    /**
     * 请求IP
     */
    String HEADER_REQUEST_IP = "request-ip";

    /**
     * 请求来源
     */
    String FROM_SOURCE = "from-source";

    /**
     * 内部请求
     */
    String INNER = "inner";

    /**
     * 用户标识
     */
    String USER_KEY = "user_key";

    /**
     * 登录用户
     */
    String LOGIN_USER = "login_user";

    /**
     * 角色权限
     */
    String ROLE_PERMISSION = "role_permission";
}
